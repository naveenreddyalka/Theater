package com.theater.seating;

import com.theater.seating.domain.Row;
import com.theater.seating.domain.Section;
import com.theater.seating.domain.Theater;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        Theater t = new Theater();
        Row r1 = t.addRow();
        Row r2 = t.addRow();
        Row r3 = t.addRow();
        Row r4 = t.addRow();
        Row r5 = t.addRow();
        
        Section r1s1 = r1.addSection(2);
        Section r1s2 = r1.addSection(3);
        r1s2.getSeats().forEach(s->s.setTaken(true));
        Section r1s3 = r1.addSection(2);
        
        Section r2s1 = r2.addSection(2);
        Section r2s2 = r2.addSection(5);
        Section r2s4 = r2.addSection(2);
        
        Section r3s1 = r3.addSection(2);
        r3s1.getSeats().forEach(s->s.setTaken(true));
        Section r3s2 = r3.addSection(2);
        Section r3s3 = r3.addSection(2);
        r3s3.getSeats().forEach(s->s.setTaken(true));
        Section r3s4 = r3.addSection(2);
        Section r3s5 = r3.addSection(2);
        
        Section r4s1 = r4.addSection(2);
        Section r4s2 = r4.addSection(2);
        Section r4s3 = r4.addSection(2);
        
        r4s1.getSeats().get(1).setTaken(true);
        r4s1.getSeats().get(0).setTaken(true);
        
        r5.addSection(15);
        t.addRow().addSection(15);
        t.addRow().addSection(15);
        t.addRow().addSection(15);

		t.getRows().get(4).getSections().forEach(sec -> sec.getSeats().forEach(s -> s.setTaken(true)));

		t.getRows().get(6).getSections().forEach(sec -> sec.getSeats().stream().limit(4).forEach(s -> 
			s.setTaken(true)));
        
        t.print();
        
    }
}
