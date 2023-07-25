package me.VideoSRC.api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.VideoSRC.Main;

public class Arquivos {
	public static FileConfiguration MiniFeast;

	public static void deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				deleteDir(new File(dir, children[i]));
			}
		}
		dir.delete();
	}

	public static void copy(InputStream in, File file) {
		try {
			OutputStream out = new FileOutputStream(file);
			byte[] buf = new byte[' '];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Arquivos() {
		try {
			loadFiles();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadFiles() throws Exception {
		File miniFile = new File(Main.instance.getDataFolder(), "itensfeast.yml");
		Integer creation = Integer.valueOf(0);
		if (!miniFile.exists()) {
			miniFile.getParentFile().mkdirs();
			copy(Main.instance.getResource("itensfeast.yml"), miniFile);
			creation = Integer.valueOf(creation.intValue() + 1);
		}
		if (creation.intValue() > 0) {
			Main.instance.getLogger().info("Arquivo " + creation + " files.");
		}
		MiniFeast = YamlConfiguration.loadConfiguration(new File(Main.instance.getDataFolder(), "itensfeast.yml"));
	}
}
