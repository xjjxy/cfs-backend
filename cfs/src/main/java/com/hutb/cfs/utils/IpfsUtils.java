package com.hutb.cfs.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;

public class IpfsUtils {
	private static IPFS ipfs = new IPFS("/ip4/127.0.0.1/tcp/2020");

	/**
	 *
	 * @param filePathName
	 *            需要上传的文件所在路径全名
	 * @return 返回文件所在ipfs服务器哈希值
	 * @throws IOException
	 */
	
	//上传字符串
	public static String upload(String content) throws IOException {

		NamedStreamable.ByteArrayWrapper byteArrayWrapper = new NamedStreamable.ByteArrayWrapper(content.getBytes());
		// 获取第一个节点
		MerkleNode addResult = ipfs.add(byteArrayWrapper).get(0);
		return addResult.hash.toString();
	}

	//上传文件
	public static String upload(File file) throws IOException {

		NamedStreamable.FileWrapper fileWrapper = new NamedStreamable.FileWrapper(file);
		
		
		// 获取第一个节点
		MerkleNode addResult = ipfs.add(fileWrapper).get(0);
		
		// 会在本地产生临时文件，用完后需要删除
				if (file.exists()) {
					file.delete();
				}
		return addResult.hash.toString();
	}
	
	public static String upload(MultipartFile mFile) throws IOException{
		System.out.println(mFile.getOriginalFilename());
		File file = new File("D:\\"+mFile.getOriginalFilename());
		FileUtils.copyInputStreamToFile(mFile.getInputStream(), file);
		
//		if (file.exists()) {
//		  file.delete();
//		}
		return upload(file);
	}

	/**
	 *
	 * @param filePathName
	 *            要下载的文件保存地址
	 * @param hash
	 *            文件哈希值
	 * @throws IOException
	 */

	// 适合需要文件的情况
	public static void download(String filePathName, String hash) throws IOException {
		Multihash filePointer = Multihash.fromBase58(hash);
		byte[] data = ipfs.cat(filePointer);
		if (data != null) {
			File file = new File(filePathName);
			if (file.exists()) {
				file.delete();
			}

			FileOutputStream fos = new FileOutputStream(file);
			fos.write(data, 0, data.length);
			fos.flush();
			fos.close();

		}
	}

	// 存入与取出格式相同
	public static String download(String hash) throws IOException {
		Multihash filePointer = Multihash.fromBase58(hash);
		byte[] data = ipfs.cat(filePointer);
		if (data != null) {
			String content = new String(data);
			return content;
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
//		System.out.println(ipfs);
//		String hash = null;
//		// try {
//		// hash = IpfsUtils.upload("C:\\Users\\zzj17\\Desktop\\打卡3.docx");
//		// } catch (IOException e) {
//		// e.printStackTrace();
//		// }
//		UserBean u = new UserBean("a", "a", "a", "a", "a", "a", "a", "a", 1);
//		String s = JSON.toJSONString(u);
//		hash = IpfsUtils.upload(s);
//		System.out.println("hash:" + hash);
//
//		// try {
//		// IpfsUtils.download("C:\\Users\\zzj17\\Desktop\\a.docx",hash);
//		// } catch (IOException e) {
//		// e.printStackTrace();
//		// }
//
//		String str = IpfsUtils.download(hash);
//		System.out.println(str);
//		System.out.println(JSONObject.parseObject(str, UserBean.class));
	}
	
	

}
