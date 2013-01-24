package ir.assignments.three;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileOutput {
	public static void appendBytesToFile(byte[] bytes, String destination) {
		try {
			boolean append = true;
			FileChannel fc = new FileOutputStream(destination,append).getChannel();
			fc.write(ByteBuffer.wrap(bytes));
			fc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeBytesToFile(byte[] bytes, String destination) {
		try {
			FileChannel fc = new FileOutputStream(destination).getChannel();
			fc.write(ByteBuffer.wrap(bytes));
			fc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
