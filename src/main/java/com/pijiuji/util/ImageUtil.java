package com.pijiuji.util;

import com.pijiuji.service.exception.ServiceException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageUtil implements Serializable {


	private static final long serialVersionUID = 1L;
//    private static String winImageUrl ="E:/pijiuji/image/";
//    private static String winVideoUrl ="E:/pijiuji/video/";
    private static String winImageUrl ="/pijiuji/file/image/";
    private static String winVideoUrl ="/pijiuji/file/video/";

    /**
     * 判断是图片还是视频
     * @param fileName
     * @return
     */
    public static String fileType(String fileName) {
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toLowerCase();
        // 创建视频类型数组
        String video[] = {"mp4", "avi", "mov", "wmv", "asf", "navi", "3gp", "mkv", "f4v", "rmvb", "webm"};
        for (int i = 0; i < video.length; i++) {
            if (video[i].equals(fileType)) {
                return "video";
            }
        }
        // 创建图片类型数组
        String imgs[] = {"bmp", "jpg", "jpeg", "png"};
        for (int i = 0; i < imgs.length; i++) {
            if (imgs[i].equals(fileType)) {
                return "image";
            }
        }
        // 创建图片类型数组
        String img[] = {"bmp", "jpg", "jpeg", "png", "tiff", "gif", "pcx", "tga", "exif", "fpx", "svg", "psd", "cdr",
                "pcd", "dxf", "ufo", "eps", "ai", "raw", "wmf"};
        for (int i = 0; i < img.length; i++) {
            if (img[i].equals(fileType)) {
                return "img";
            }
        }
        return "error";
    }

    /**
     * 上传图片
     * @param file
     * @return
     */
    public static String uploadFileImage(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        fileName = FileUtil.renameToUUID(fileName).replace("-", "");
        try {
            FileUtil.uploadFile(file.getBytes(),winImageUrl , fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/smallapple/" + fileName;
    }

	/**
	 * 保存视频的返回地址和封面的返回地址
	 *
     * @param file
	 * @return
	 * @throws IOException
	 */
	public static Map<String, String> uploadvideo(String addreas,MultipartFile file) {
        String fileName = file.getOriginalFilename();
        fileName = FileUtil.renameToUUID(fileName).replace("-", "");
        try {
            FileUtil.uploadFile(file.getBytes(), winVideoUrl, fileName);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
        //  "/smallapple/" + fileName
        String videoUrl = addreas + "/smallapple/" + fileName;
        int i = fileName.lastIndexOf(".");
        String url = fileName.substring(0,i)+".jpg";
        String imageUrl = winImageUrl+ url;
		try {
			fetchFrame(videoUrl, imageUrl);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		Map<String, String> map = new HashMap<>();
		map.put("video", "/smallapple/" + fileName);
		map.put("image", "/smallapple/" + url);
		return map;
	}

	/**
	 * 获取指定视频的帧并保存为图片至指定目录
	 * 
	 * @param videofile 源视频文件路径
	 * @param framefile 截取帧的图片存放路径
	 * @throws Exception
	 */
	public static void fetchFrame(String videofile, String framefile) throws Exception {
		File file = new File(framefile);
		if (!file.exists()) {
			file.createNewFile();
		}
		List<String> commands = new java.util.ArrayList<String>();
		commands.add("D:\\ffmpeg\\bin\\ffmpeg.exe");
		commands.add("-i");
		commands.add(videofile);
		commands.add("-y");
		commands.add("-f");
		commands.add("image2");
		commands.add("-ss");
		commands.add("2");// 这个参数是设置截取视频多少秒时的画面
		commands.add("-s");
		commands.add("800x600");
		commands.add(framefile);
		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commands);
			builder.start();
			System.out.println("截取成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
