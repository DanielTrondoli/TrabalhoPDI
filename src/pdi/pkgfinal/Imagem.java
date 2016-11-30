/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdi.pkgfinal;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
class Imagem {

    private String tipo = null;
    private String coment = null;
    private File file = null;
    private int W = 0, H = 0;
    private short T = 0;
    private int maxPix = -1;
    private int[][] imgPGM = null;
    private int[][][] imgPPM = null;
    private BufferedImage image = null;
    private char[][] imgPBM = null;

    public Imagem() {
    }

    Imagem(Imagem img) {
        this.H = img.getH();
        this.W = img.getW();
        this.T = img.getT();
        this.coment = img.getComent();
        this.tipo = img.getTipo();
        this.maxPix = img.getMaxPix();
        this.file = img.getFile();
    }

    public boolean carregaImagem(File arq) {
        try {
            file = arq;
            FileInputStream fis = new FileInputStream(arq);
            //BufferedInputStream in = new BufferedInputStream(fis);
            Scanner scan = new Scanner(fis);
            tipo = scan.nextLine();

            if (tipo.equals("P1") || tipo.equals("P2") || tipo.equals("P3")) {

                coment = scan.nextLine();
                if (coment.charAt(0) != '#') { // SEM COMENTARIO
                    W = Integer.valueOf(coment.substring(0, coment.indexOf(' ')));
                    H = Integer.valueOf(coment.substring(coment.indexOf(' ') + 1));
                    coment = "No Coments.";
                } else {//                        COM COMENTARIO
                    // terceira linha - Width, Height
                    W = scan.nextInt();
                    H = scan.nextInt();
                }
                // quarta linha - Pixel Max
                switch (tipo) {
                    case "P1": // PBM
                        T = 1;
                        PBMImage(scan);
                        break;
                    case "P2": // PGM
                        T = 2;
                        maxPix = scan.nextInt();
                        PGMImage(scan);
                        break;
                    case "P3": // PPM
                        T = 3;
                        maxPix = scan.nextInt();
                        PPMImage(scan);
                        break;
                    default:
                        return false;
                }
            } else {
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(Imagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private void PGMImage(Scanner scan) {
        float fator = (float) (255.0 / maxPix);
        imgPGM = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int p = scan.nextInt();
                imgPGM[i][j] = p;
            }
        }
    }

    private void PPMImage(Scanner scan) {
        imgPPM = new int[H][W][3];
        int[] pixel = new int[3];
        int cont = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                for (int k = 0; k < 3; k++) {
                    int p = scan.nextInt();
                    imgPPM[i][j][k] = p;
                }
            }
        }
    }

    private void PBMImage(Scanner scan) {
        imgPBM = new char[H][W];
        int[] pixel = new int[3];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                imgPBM[i][j] = (char) scan.nextInt();
            }
        }
    }

    public void gerarImagem() {
        int[] pixel = new int[3];
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = image.getRaster();
        switch (T) {
            case 1:
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        if ((int) imgPBM[i][j] == 1) {
                            pixel[0]
                                    = pixel[1]
                                    = pixel[2] = 0;
                        } else {
                            pixel[0]
                                    = pixel[1]
                                    = pixel[2] = 255;
                        }
                        raster.setPixel(j, i, pixel);
                    }
                }
                break;
            case 2:
                int fator = (256 / (maxPix + 1));
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        pixel[0]
                                = pixel[1]
                                = pixel[2]
                                = imgPGM[i][j] * fator;
                        raster.setPixel(j, i, pixel);
                    }
                }
                break;
            case 3:
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        System.arraycopy(imgPPM[i][j], 0, pixel, 0, 3);
                        raster.setPixel(j, i, pixel);
                    }
                }
                break;
            default:
                return;
        }
    }

    void carregarImagemPNG(File arq) {
        try {
            BufferedImage imagem = ImageIO.read(arq);
            int w = imagem.getWidth();
            int h = imagem.getHeight();
            int r, g, b, p;
            int[] pixels = imagem.getRGB(0, 0, w, h, null, 0, w);
            imgPPM = new int[h][w][3];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    p = pixels[i * w + j];
                    r = (p & 255);
                    g = ((p & 65280) / 256);
                    b = ((p & 16711680) / 65536);
                    imgPPM[i][j][0] = b;
                    imgPPM[i][j][1] = g;
                    imgPPM[i][j][2] = r;
                }
            }
            T = 3;
            H = h;
            W = w;
            tipo = "P3";
            coment = "No Coments";
        } catch (IOException ex) {
            Logger.getLogger(Imagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    int[] getHistograma() {
        int[] v = new int[256];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (T == 2) {
                    v[imgPGM[i][j]]++;
                } else if (T == 3) {
                    v[(imgPPM[i][j][0] + imgPPM[i][j][1] + imgPPM[i][j][2]) / 3]++;
                }
            }
        }
        return v;
    }

    void gravarHistograma() {
        FileWriter fw;
        try {
            int[] v = getHistograma();
            String nome = file.getAbsolutePath();
            nome = nome.substring(0, nome.lastIndexOf('.'));
            fw = new FileWriter(new File(nome + " Histograma.txt"));
            PrintWriter gravarArq = new PrintWriter(fw);
            for (int i = 0; i < v.length; i++) {
                gravarArq.printf(i + " -> " + v[i] + "%n");
            }
            gravarArq.flush();
            gravarArq.close();

        } catch (IOException ex) {
            System.out.println("ERRO");
        }
    }

    public void salvarComo(File arq) {
        FileWriter img;
        try {
            img = new FileWriter(arq);
            PrintWriter gravarArq = new PrintWriter(img);
            String ext = arq.getName().substring(arq.getName().lastIndexOf('.'));
            if (ext.equals(".ppm")) {
                gravarArq.printf("P3" + "%n");
            } else if (ext.equals(".pbm")) {
                gravarArq.printf("P1" + "%n");
            } else if (ext.equals(".pgm")) {
                gravarArq.printf("P2" + "%n");
            } else {
                return;
            }
            gravarArq.printf("# by DT" + "%n");
            gravarArq.printf(W + " " + H + "%n");

            switch (T) {
                case 1://PBM
                    if (ext.equals(".ppm")) {
                        gravarArq.printf("255" + "%n");
                        for (int i = 0; i < H; i++) {
                            for (int j = 0; j < W; j++) {
                                if (imgPBM[i][j] == 0) {
                                    gravarArq.printf("255" + " ");
                                    gravarArq.printf("255" + " ");
                                    gravarArq.printf("255" + " ");
                                } else {
                                    gravarArq.printf("0" + " ");
                                    gravarArq.printf("0" + " ");
                                    gravarArq.printf("0" + " ");
                                }
                            }
                        }
                    } else if (ext.equals(".pbm")) {
                        for (int i = 0; i < H; i++) {
                            for (int j = 0; j < W; j++) {
                                gravarArq.printf(((int) imgPBM[i][j]) + " ");
                            }
                        }
                    } else if (ext.equals(".pgm")) {
                        gravarArq.printf("255" + "%n");
                        for (int i = 0; i < H; i++) {
                            for (int j = 0; j < W; j++) {
                                if (imgPBM[i][j] == 0) {
                                    gravarArq.printf("255" + " ");
                                } else {
                                    gravarArq.printf("0" + " ");
                                }
                            }
                        }
                    }
                    break;
                case 2://PGM
                    if (ext.equals(".ppm")) {
                        gravarArq.printf(maxPix + "%n");
                        for (int i = 0; i < H; i++) {
                            for (int j = 0; j < W; j++) {
                                gravarArq.printf(imgPGM[i][j] + " ");
                                gravarArq.printf(imgPGM[i][j] + " ");
                                gravarArq.printf(imgPGM[i][j] + " ");
                            }
                            gravarArq.printf("%n");
                        }
                    } else if (ext.equals(".pbm")) {
                        for (int i = 0; i < H; i++) {
                            for (int j = 0; j < W; j++) {
                                if (imgPGM[i][j] > 128) {
                                    gravarArq.printf("0" + " ");
                                } else {
                                    gravarArq.printf("1" + " ");
                                }
                            }
                            gravarArq.printf("%n");
                        }
                    } else if (ext.equals(".pgm")) {
                        gravarArq.printf(maxPix + "%n");
                        for (int i = 0; i < H; i++) {
                            for (int j = 0; j < W; j++) {
                                gravarArq.printf(imgPGM[i][j] + " ");
                            }
                            gravarArq.printf("%n");
                        }
                    }
                    break;

                case 3://PPM

                    if (ext.equals(".ppm")) {
                        gravarArq.printf(maxPix + "%n");
                        for (int i = 0; i < H; i++) {
                            for (int j = 0; j < W; j++) {
                                for (int k = 0; k < 3; k++) {
                                    gravarArq.printf(imgPPM[i][j][k] + " ");
                                }
                            }
                            gravarArq.flush();
                            //gravarArq.printf("%n");
                        }
                    } else if (ext.equals(".pbm")) {
                        for (int i = 0; i < H; i++) {
                            for (int j = 0; j < W; j++) {
                                int m = (imgPPM[i][j][0] + imgPPM[i][j][1] + imgPPM[i][j][2]) / 3;
                                if (m > 128) {
                                    gravarArq.printf("0" + " ");
                                } else {
                                    gravarArq.printf("1" + " ");
                                }
                            }
                            gravarArq.flush();
                            gravarArq.printf("%n");
                        }
                    } else if (ext.equals(".pgm")) {
                        gravarArq.printf(maxPix + "%n");
                        for (int i = 0; i < H; i++) {
                            for (int j = 0; j < W; j++) {
                                int m = (imgPPM[i][j][0] + imgPPM[i][j][1] + imgPPM[i][j][2]) / 3;
                                gravarArq.printf(m + " ");
                            }
                            gravarArq.flush();
                            gravarArq.printf("%n");
                        }
                    }
                default:
                    return;
            }
            gravarArq.flush();
            gravarArq.flush();

            gravarArq.close();
            img.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "erro ao salvar");
            return;
        }
    }    
    
    public String getTipo() {
        return tipo;
    }

    public String getComent() {
        return coment;
    }

    public File getFile() {
        return file;
    }

    public int getW() {
        return W;
    }

    public int getH() {
        return H;
    }

    public short getT() {
        return T;
    }

    public int getMaxPix() {
        return maxPix;
    }

    public int[][] getImgPGM() {
        return imgPGM;
    }

    
    public int[][][] getImgPPM() {
        return imgPPM;
    }

    public BufferedImage getImage() {
        return image;
    }

    public char[][] getImgPBM() {
        return imgPBM;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    public void setW(int W) {
        this.W = W;
    }

    public void setH(int H) {
        this.H = H;
    }

    public void setT(short T) {
        this.T = T;
    }

    public void setMaxPix(int maxPix) {
        this.maxPix = maxPix;
    }

    public void setImgPGM(int[][] imgPGM) {
        this.imgPGM = imgPGM;
    }

    public void setImgPPM(int[][][] imgPPM) {
        this.imgPPM = imgPPM;
    }

    public void setImgPBM(char[][] imgPBM) {
        this.imgPBM = imgPBM;
    }

    //    void carregarImagemNC(NumComplex[][] mtz) {
//        H = mtz.length;
//        W = mtz[0].length;
//        T = 2;
//        maxPix = 255;
//        tipo = "P2";
//        coment = "No Coments";
//        imgPGM = new int[H][W];
//        for (int i = 0; i < H; i++) {
//            for (int j = 0; j < W; j++) {
//                imgPGM[i][j] = (int) Math.round(mtz[i][j].modulo());
//            }
//        }
//    }
}
