package junitaccount;

/*********************************************************************
 * Represents a customer account at a small store.
 *
 * @author Nathan Sprague
 * @version V1.0, 02/2012
 *
 *********************************************************************/
public class Account {
    // اسم العميل
    private String name;
    // عنوان العميل
    private String address;
    // تاريخ فتح الحساب
    private final String openDate;
    // مجموع قيمة المشتريات
    private int totalPurchases; // in pennies
    // الحد الأعلى للرصيد عند المحل
    private int chargeLimit; // in pennies
    // الرصيد عند المحل
    private int chargeBalance; // in pennies
    // حالة الحساب (مفتوح، مغلق )
    private boolean accountOpen;

    // مبلغ المشتريات المطلوب لكي يصبح الحساب مؤهل لخدمة الرصيد عند المحل
    private static final int CHARGE_ELIGIBILITY_THRESHOLD = 50000;

    /***********************************************************
     * Construct a new account.
     *
     * @param name     Name of primary account holder.
     * @param address  Address of primary account holder.
     * @param openDate Date account was opened.
     ***********************************************************/
    public Account(String name, String address, String openDate) {
        this.name = name;
        this.address = address;
        this.openDate = openDate;
        this.totalPurchases = 0;
        this.chargeLimit = 0;
        this.chargeBalance = 0;
        this.accountOpen = true;
    }

    /***********************************************************
     * Construct a new account, using today's date as the openDate.
     *
     * @param name    Name of primary account holder.
     * @param address Address of primary account holder.
     ***********************************************************/
    public Account(String name, String address) {
        this(name, address, "12-12-2023");
    }

    /***********************************************************
     * دالة تقوم بإضافة قيمة مشتريات جديدة لمجموع مشتريات العميل
     * إذا كانت قيمة المشتريات بالسالب، فهذا يعني أنه ارجاع
     * Post a purchase to the account. Purchases may be positive
     * or negative (indicating returns). Returns may not bring
     * total purchases below 0.
     *
     * @param purchaseAmount The amount of the purchase in pennies.
     * @throws InvalidReturnException If a negative purchase
     *                                (return) would bring total purchases below 0.
     ***********************************************************/
    public void postPurchase(int purchaseAmount) {
        if (totalPurchases + purchaseAmount < 0)
            throw new InvalidReturnException("Total purchases may " +
                    " not be negative.");

        totalPurchases += purchaseAmount;
    }

    /***********************************************************
     * دالة تضيف ملبغ إلى مجموع رصيد العميل لدى المحل
     * Post a charge to the account. When this method is called
     * the charge balance will be increased by the charge amount.
     * Charges may not be negative and may not cause the charge
     * balance to exceed the charge limit. In the case of an invalid
     * charge, an exception will be raised and the charge balance
     * will remain unchanged.
     *
     * @param chargeAmount The amount, in pennies, to be charged.
     * @throws LimitExceededException   Thrown if the charges exceed
     *                                  the charge limit.
     * @throws IllegalArgumentException Thrown in the case of a
     *                                  negative charge amount.
     ***********************************************************/
    public void postCharge(int chargeAmount) {
        if (chargeAmount < 0)
            throw new IllegalArgumentException("Negative charges not allowed.");

        if (chargeAmount + chargeBalance > getChargeLimit())
            throw new LimitExceededException("Charge exceeds charge limit.");

        chargeBalance += chargeAmount;
    }

    /***********************************************************
     * دالة تقوم بخصم قيمة طلب جديد من الرصيد المتوفر لدى العميل
     * Post a payment to the account. This will decrease the
     * the current charge balance and may result in a negative balance
     * (indicating store credit). Negative payments are not allowed.
     * Any reduction in the current charge balance is added to total
     * Purchases.
     *
     * @param paymentAmount The amount (in pennies) to apply to
     *                      the charge balance.
     * @throws IllegalArgumentException Thrown in the case of a
     *                                  negative payment.
     ***********************************************************/
    public void postPayment(int paymentAmount) {
        if (paymentAmount < 0)
            throw new IllegalArgumentException("Negative payments " +
                    "not allowed.");

        if (paymentAmount <= chargeBalance) {
            // Payed charges are counted as purchases.
            postPurchase(paymentAmount);
        } else {
            // Balance is completely paid off, convert it all to purchases.
            postPurchase(chargeBalance);
        }
        chargeBalance -= paymentAmount;

    }

    /***********************************************************
     * دالة تقرر إذا كان الحساب مؤهل لخدمة الرصيد لدى المحل
     * يجب أن يكون الحساب مفتوح ليصبح مؤهل ومجموع المشتريات يتجاوز الحد المطلوب
     * Check to see if the account is eligible to be granted a
     * non-0 charge limit. This will be true if the account is
     * open and the customer has posted at least
     * CHARGE_ELIGIBILITY_THRESHOLD in purchases.
     *
     * @return true if the account is eligible, false otherwise.
     ***********************************************************/
    public boolean isEligibleForCharge() {
        boolean result = false;
        if (totalPurchases >= CHARGE_ELIGIBILITY_THRESHOLD && accountOpen) {
            result = true;
        }
        return result;
    }

    /***********************************************************
     * Set the account name.
     *
     * @param name Name of primary account holder.
     ***********************************************************/
    public void setName(String name) {
        this.name = name;
    }

    /***********************************************************
     * Set the account address.
     *
     * @param address Address of primary account holder.
     ***********************************************************/
    public void setAddress(String address) {
        this.address = address;
    }

    /***********************************************************
     * Modify the current charge limit.
     *
     * @param newLimit The new charge limit in pennies.
     * @throws IllegalArgumentException In the case of a negative
     *                                  charge limit.
     ***********************************************************/
    public void setChargeLimit(int newLimit) {
        if (newLimit < 0)
            throw new IllegalArgumentException("Negative charge limit " +
                    "not allowed.");

        this.chargeLimit = newLimit;

    }

    /***********************************************************
     * Set the account status to "open" or "closed"
     *
     * @param open true if the account should be open, false if
     *             it should be closed.
     ***********************************************************/
    public void setAccountStatus(boolean open) {
        this.accountOpen = open;
    }

    /***********************************************************
     * Create a string representation of the account.
     *
     * @return String representation.
     ***********************************************************/
    public String toString() {
        String result;
        result = "Account Information\n";
        result += "\t" + name + "\n";
        result += "\t" + address.replace("\n", "\n\t") + "\n";
        result += "\tAccount Open Date: " + openDate + "\n";
        result += "\tTotal Purchases:   " + totalPurchases + "\n";
        result += "\tCharge Limit:      " + chargeLimit + "\n";
        result += "\tCurrent Tab:       " + chargeBalance + "\n";
        result += "\tAccount Status:    ";
        if (accountOpen)
            result += "Open";
        else
            result += "Closed";

        return result;
    }

    /***********************************************************
     * Return the name associated with this account.
     *
     * @return Name of account holder.
     ***********************************************************/
    public String getName() {
        return name;
    }

    /***********************************************************
     * Return the address associated with this account.
     *
     * @return Address of account holder.
     ***********************************************************/
    public String getAddress() {
        return address;
    }

    /***********************************************************
     * Get the account open date.
     *
     * @return Account open date.
     ***********************************************************/
    // it was GregorianCalendar
    public String getOpenDate() {
        return openDate;
    }

    /***********************************************************
     * Get the total purchases for this account.
     *
     * @return total purchases in pennies.
     ***********************************************************/
    public int getTotalPurchases() {
        return totalPurchases;
    }

    /***********************************************************
     * Return the current charge limit, taking into account whether
     * or not the account is currently open.
     *
     * @return The charge limit, in pennies.
     ***********************************************************/
    public int getChargeLimit() {
        int result = this.chargeLimit;
        if (!accountOpen) {
            result = 0;
        }
        return result;
    }

    /***********************************************************
     * Return the current charge balance. Positive values indicate
     * that the customer owes money on the account.
     *
     * @return The charge limit, in pennies.
     ***********************************************************/
    public int getChargeBalance() {
        return chargeBalance;
    }
}
