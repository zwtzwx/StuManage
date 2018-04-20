package com.zwt.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ImageSerlet")
public class ImageSerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ImageSerlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * ����ͼƬ�õ�����
		 * BufferedImageͼ�����ݻ�����
		 * Graphics����ͼƬ
		 * Color��ȡ��ɫ
		 * Random���������
		 * ImageIO���ͼƬ
		 */
		
		/*
		 * ImageServlet��
		 * ��1������BufferedImage����
		 * ��2�����Graphics����
		 * ��3��ͨ��Random���������֤����Ϣ
		 * ��4��ʹ��Graphics����ͼƬ
		 * ��5����¼��֤����Ϣ��session��
		 * ��6��ʹ��ImageIO���ͼƬ
		 */
		
		BufferedImage bf = new BufferedImage(68,22,BufferedImage.TYPE_INT_RGB);
		
		Graphics gp = bf.getGraphics();
		
		Color c = new Color(200,150,255);
		
		gp.setColor(c);
		
		gp.fillRect(0, 0, 68, 22);
		
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		int len=ch.length,index;
		for(int i=0; i<4; i++) {
			index = r.nextInt(len);
			gp.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));
			
			gp.drawString(ch[index]+"", (i*15)+3, 18);
			
			sb.append(ch[index]);
		}
		
		request.getSession().setAttribute("piccode", sb.toString());
		
		ImageIO.write(bf, "JPG", response.getOutputStream());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
