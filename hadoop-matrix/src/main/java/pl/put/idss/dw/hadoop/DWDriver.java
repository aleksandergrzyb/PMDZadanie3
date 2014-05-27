package pl.put.idss.dw.hadoop;

import org.apache.hadoop.util.ProgramDriver;

import pl.put.idss.dw.hadoop.tasks.MVMultTask;
import pl.put.idss.dw.hadoop.tasks.MMMultTask;

public class DWDriver {

	public static void main(String[] args) {
		ProgramDriver driver = new ProgramDriver();
		try {
			driver.addClass("mv-mult", MVMultTask.class, "Matrix-vector multiplication with vector in memory");
			driver.addClass("mm-mult", MMMultTask.class, "Matrix-matrix multiplication");
			
			driver.driver(args);
			System.exit(0);
		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
