package com.pubfactory.test;


import static org.junit.Assert.assertEquals;



import org.junit.Test;

/**
 * The Safari Java Test part 1 of 2.
 * <p/>
 * Get all the tests in this class to pass. Tests are written in JUnit 4.  You may introduce
 * new dependencies if you wish to use existing libraries.
 *
 * DO NOT CHANGE THE TESTS THAT ARE HERE
 * You may however add any tests that you wish.
 *
 * The CSV "file" is provided as text in the test class.  Do not modify the sample data.
 */
public class CsvParserTest {

    @Test
    public void testCellValues() throws Exception {  // was IOException
        CsvParser parser = new CsvParser(sample1);
        assertEquals("5083604", parser.getCellValue("SAP Customer", 0));
        
        // none of the indixes correspond to assert value in the test scope
        assertEquals("Appalachian College Association Central Library (ACA)", parser.getCellValue("Name", 20));

        // empty rows
        
        assertEquals("445885", parser.getCellValue("AMS Subscription", 11));
        assertEquals("", parser.getCellValue("AMS Subscription", 12));
        // none of the indixes correspond to assert value in the test scope.

        assertEquals("31", parser.getCellValue("Total", 23));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadColumn() throws Exception {
        CsvParser parser = new CsvParser(sample1);
        parser.getCellValue("Some bad column name", 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testLowIndex() throws Exception {
        CsvParser parser = new CsvParser(sample1);
        parser.getCellValue("SAP Customer", -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexTooLarge() throws Exception {
        CsvParser parser = new CsvParser(sample1);
        parser.getCellValue("SAP Customer", 24);
    }


    String sample1 = "SAP Customer,SAP Order,AMS Subscriber,Customer Type,Name,Address 1,Address 2,Address 3,City,State,Country,Postal Code,CC Type,CC Number,CC Exp Date,AMS Subscription,ISBN,Start Date,End Date,Subscription Type,Price,PO,Quantity,Update Type,Price Adjust,Price Adjust Type,Cancellation Adjustment,Sales Rep,Line Item Text,Comments,Commission Price,Count,Total\n5083604,0,28240,INDIVIDUAL,Joe Cooper,243 St. Leonard's Avenue,,,Toronto,ON,CA,M4N 1K9,VISA,1234,1-Jan-08,445798,1561592633,8-May-05,30-Apr-06,FIXED_TERM,295,Cooper,1,ORDER,,,N,,,,,1,31\n5125642,,91298,INDIVIDUAL,jane campbell,box 696,,,new lenox,IL,US,60451,MC,1234,30-Apr-08,445983,195216814,9-May-05,30-Sep-32,MONTHLY,29.95,campbell,1,,,,N,,,,,2,31\n5142987,,109936,INDIVIDUAL,Don Linneman,308 N. Coolidge,,,normal,IL,US,61761,MC,1234,31-Jan-08,446017,195216814,9-May-05,31-May-06,FIXED_TERM,295,Linneman,1,,,,N,,,,,3,31\n5185291,774952,205888,INDIVIDUAL,Joe sutherland,4622 sylvan rd,,,richmond,VA,US,23225,VISA,2415,1-May-07,219749,195216814,11-Dec-04,10-May-05,MONTHLY,29.95,sutherland,1,ORDER,,,N,,,,,4,31\n5188765,795484,208550,INDIVIDUAL,Kris Burnett,335 Shanty Lake Drive,,,Chattanooga,TN,US,37419,MC,53290215,1-Aug-06,228097,195216814,11-Jan-05,10-May-05,MONTHLY,29.95,McBurnett,1,ORDER,,,N,,,,,5,31\n5191644,,217064,INDIVIDUAL,Lew Cozad,21550 Highway 92,,,Platte City,MO,US,64079,MC,549015,1-Sep-05,446059,195216814,9-May-05,8-Jun-05,MONTHLY,29.95,Cozad,1,,,,N,,,,,6,31\n5193169,821412,217989,INDIVIDUAL,Megan Kind,1975 Aquarena Springs Dr.,Apt. 1115,,San Marcos,TX,US,78666,AMEX,3396514,1-Mar-08,252150,195221346,11-Feb-05,10-May-05,MONTHLY,19.95,Kindinger,1,ORDER,,,N,,,,,7,31\n5193177,821421,218044,INDIVIDUAL,Jake Bose,2524 Alvecot Circle,,,Smyrna,GA,US,30080,VISA,4828515,1-Mar-07,252213,195216814,11-Feb-05,10-May-05,MONTHLY,29.95,DuBose,1,ORDER,,,N,,,,,8,31\n5200472,860509,221425,INDIVIDUAL,Ray Smith,5395 N Angela,,,Memphis,TN,US,38120,MC,5491215,1-Nov-06,257281,1561592633,11-Apr-05,10-May-05,MONTHLY,29.95,Curle,1,ORDER,,,N,,,,,9,31\n,,222660,INDIVIDUAL,Thomas Jones,5309 Hammond Ave,,,Superior,WI,US,54880,MC,5424115,1-Mar-06,445854,195216814,8-May-05,30-Sep-32,MONTHLY,29.95,Amorde,1,,,,N,,,,,10,31\n,,222662,INDIVIDUAL,Elliot David,8920 Woodman Way,,,Sacramento,CA,US,95826,AMEX,37151314,1-Mar-09,445873,1561592633,8-May-05,31-May-06,FIXED_TERM,295,Elliott,1,,,,N,,,,,11,31\n,,222664,INDIVIDUAL,Bruce Majors,1640 E. 50th St.,,,Chicago,IL,US,60615,VISA,43815,1-Sep-07,445885,1561592633,9-May-05,30-Sep-32,MONTHLY,29.95,Bruce,1,,,,N,,,,,12,31\n5142987,,109936,INDIVIDUAL,Jim Linneman,308 N. Coolidge,,,normal,IL,US,61761,MC,54661615,31-Jan-08,,,,,,,,,ACCOUNT,,,N,,,,,13,31\n5083604,,28240,INDIVIDUAL,Jake Cooper,243 St. Leonard's Avenue,,,Toronto,ON,CA,M4N 1K9,VISA,4537075,1-Jan-08,,,,,,,,,ACCOUNT,,,N,,,,,14,31\n5125642,,91298,INDIVIDUAL,Linda campbell,box 696,,,new lenox,IL,US,60451,MC,55015,30-Apr-08,,,,,,,,,ACCOUNT,,,N,,,,,15,31\n5168705,,195828,INDIVIDUAL,Mike Elliott,8920 Woodman Way,,,Sacramento,CA,US,95826,AMEX,3715134,1-Mar-09,,,,,,,,,ACCOUNT,,,N,,,,,16,31\n5191644,,217064,INDIVIDUAL,Bill Cozad,21550 Highway 92,,,Platte City,MO,US,64079,MC,5.49099E+15,1-Sep-05,,,,,,,,,ACCOUNT,,,N,,,,,17,31\n1059701,,2006,BUSINESS,Catholic University of America,Mullen Library,Serials Department,,Washington,DC,US,20064,,,,,,,,,,,,ACCOUNT,,,N,,,,,25,31\n1084100,,1015,BUSINESS,Oxford Online OUP-USA,OUP Employee Access Only,198 Madison Ave,,New York,NY,US,10016,,,,,,,,,,,,ACCOUNT,,,N,,,,,26,31\n1045175,,10703,BUSINESS,U.S. Military Academy - West Point,USMA Library,757 Thayer Rd,,West Point,NY,US,10996,VISA,4.7163E+15,1-Aug-07,,,,,,,,,ACCOUNT,,,N,,,,,27,31\n1060604,,19407,BUSINESS,Appalachian College Association Central Library (ACA),2875 Black Oak Road,,,Jefferson City,TN,US,37760,,,,,,,,,,,,ACCOUNT,,,N,,,,,28,31\n1064745,,24589,BUSINESS,Newark Academy (Infolink),Attn: Library,91 South Orange Avenue,,Livingston,NJ,US,7039,,,,,,,,,,,,ACCOUNT,,,N,,,,,29,31\n1071634,,86203,BUSINESS,MetaLib, MetaLib KnowledgeBase,100 Galen St,,Watertown,MA,US,02472-4502,,,,,,,,,,,,ACCOUNT,,,N,,,,,30,31\n1064746,,5370,BUSINESS,Marion County Internet Library,Bill to: Elaine Drew; Marion County Public Library,Indianapolis-Marion County Public Library; P.O. Box 211,,Indianapolis,IN,US,46202-0211,,,,,,,,,,,,ACCOUNT,,,N,,,,,31,31";
}
