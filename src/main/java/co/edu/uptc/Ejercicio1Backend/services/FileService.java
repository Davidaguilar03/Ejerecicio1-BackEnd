package co.edu.uptc.Ejercicio1Backend.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileService {
	File f;
	FileWriter fw;
	FileOutputStream fo;
	OutputStreamWriter osw;
	BufferedWriter bw = null;
	FileReader fr;
	BufferedReader br = null;
	FileInputStream fl = null;
	InputStreamReader isr = null;

	public FileService(String nameFile) {
		f = new File(nameFile);
	}

	public void open(char modo) {
		try {
			if (modo == 'w') {
				fw = new FileWriter(f);
				fo = new FileOutputStream(f);
				osw = new OutputStreamWriter(fo, StandardCharsets.UTF_8);
				bw = new BufferedWriter(osw);
			} else {
				fr = new FileReader(f);
				fl = new FileInputStream(f);
				isr = new InputStreamReader(fl, StandardCharsets.UTF_8);
				br = new BufferedReader(isr);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void save(String cad) {
		if (bw != null) {
			try {
				bw.write(cad);
				bw.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

	public ArrayList<String> read() {
		ArrayList<String> cads = new ArrayList<>();
		String cad;
		try {
			while ((cad = br.readLine()) != null) {
				cads.add(cad);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cads;
	}

	public byte[] readByte() {
		byte[] bytes = new byte[(int) f.length()];
		try {
			bytes = fl.readAllBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bytes;
	}

	public void close() {
		try {
			if (br != null)
				br.close();
			if (bw != null)
				bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
