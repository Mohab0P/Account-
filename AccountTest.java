/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mohab
 */
public class AccountTest {
    
    public AccountTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void main(){
            boolean Res;
        System.out.println("isEligibleForCharge");
        Account Ac = new Account("Mohab", "MED", "10-10-2002");
        Res = Ac.isEligibleForCharge();
        System.out.println("the Account Eligible before carege " + Res);
        Ac.postPurchase(50001);
        Res = Ac.isEligibleForCharge();

        System.out.println("the Account Eligible aftre carege " + Res + " " + Ac.toString());

    }
    
//    /**
//     * Test of postPurchase method, of class Account.
//     */
//    @Test
//    public void testPostPurchase() {
//        System.out.println("postPurchase");
//        int purchaseAmount = 0;
//        Account instance = null;
//        instance.postPurchase(purchaseAmount);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of postCharge method, of class Account.
//     */
//    @Test
//    public void testPostCharge() {
//        System.out.println("postCharge");
//        int chargeAmount = 0;
//        Account instance = null;
//        instance.postCharge(chargeAmount);
//        // TODO review the generated test code and remove the default call to fail.
//       // fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of postPayment method, of class Account.
//     */
//    @Test
//    public void testPostPayment() {
//        System.out.println("postPayment");
//        int paymentAmount = 0;
//        Account instance = null;
//        instance.postPayment(paymentAmount);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of isEligibleForCharge method, of class Account.
//     */
//    @Test
//    public void testIsEligibleForCharge() {
//        System.out.println("isEligibleForCharge");
//        Account instance = null;
//        boolean expResult = false;
//        boolean result = instance.isEligibleForCharge();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//       // fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setName method, of class Account.
//     */
//    @Test
//    public void testSetName() {
//        System.out.println("setName");
//        String name = "";
//        Account instance = null;
//        instance.setName(name);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setAddress method, of class Account.
//     */
//    @Test
//    public void testSetAddress() {
//        System.out.println("setAddress");
//        String address = "";
//        Account instance = null;
//        instance.setAddress(address);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setChargeLimit method, of class Account.
//     */
//    @Test
//    public void testSetChargeLimit() {
//        System.out.println("setChargeLimit");
//        int newLimit = 0;
//        Account instance = null;
//        instance.setChargeLimit(newLimit);
//        // TODO review the generated test code and remove the default call to fail.
//      //  fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setAccountStatus method, of class Account.
//     */
//    @Test
//    public void testSetAccountStatus() {
//        System.out.println("setAccountStatus");
//        boolean open = false;
//        Account instance = null;
//        instance.setAccountStatus(open);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toString method, of class Account.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Account instance = null;
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getName method, of class Account.
//     */
//    @Test
//    public void testGetName() {
//        System.out.println("getName");
//        Account instance = null;
//        String expResult = "";
//        String result = instance.getName();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAddress method, of class Account.
//     */
//    @Test
//    public void testGetAddress() {
//        System.out.println("getAddress");
//        Account instance = null;
//        String expResult = "";
//        String result = instance.getAddress();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getOpenDate method, of class Account.
//     */
//    @Test
//    public void testGetOpenDate() {
//        System.out.println("getOpenDate");
//        Account instance = null;
//        String expResult = "";
//        String result = instance.getOpenDate();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTotalPurchases method, of class Account.
//     */
//    @Test
//    public void testGetTotalPurchases() {
//        System.out.println("getTotalPurchases");
//        Account instance = null;
//        int expResult = 0;
//        int result = instance.getTotalPurchases();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//       // fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getChargeLimit method, of class Account.
//     */
//    @Test
//    public void testGetChargeLimit() {
//        System.out.println("getChargeLimit");
//        Account instance = null;
//        int expResult = 0;
//        int result = instance.getChargeLimit();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getChargeBalance method, of class Account.
//     */
//    @Test
//    public void testGetChargeBalance() {
//        System.out.println("getChargeBalance");
//        Account instance = null;
//        int expResult = 0;
//        int result = instance.getChargeBalance();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
    
}
