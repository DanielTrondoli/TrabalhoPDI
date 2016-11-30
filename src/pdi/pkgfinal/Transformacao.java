/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdi.pkgfinal;

import java.awt.Color;

/**
 *
 * @author pc
 */
public class Transformacao {

    public static Imagem ClarearSoma(Imagem img, int s) {
        if (s < 1) {
            return null;
        }
        if (img.getT() == 2) {
            Imagem aux = new Imagem(img);
            int[][] Maux = new int[img.getH()][img.getW()];
            int[][] M = img.getImgPGM();
            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    int p = M[i][j] + s;
                    Maux[i][j] = p > 255 ? 255 : p;
                }
            }
            aux.setImgPGM(Maux);
            return aux;
        }
        if (img.getT() == 3) {
            Imagem aux = new Imagem(img);
            int[][][] Maux = new int[img.getH()][img.getW()][3];
            int[][][] M = img.getImgPPM();
            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    for (int k = 0; k < 3; k++) {
                        Maux[i][j][k] = M[i][j][k] + s > 255 ? 255 : M[i][j][k] + s;
                    }
                }
            }
            aux.setImgPPM(Maux);
            return aux;
        }
        return null;
    }

    public static Imagem ClarearMultp(Imagem img, float m) {
        if (m < 2) {
            return null;
        }
        if (img.getT() == 2) {
            Imagem aux = new Imagem(img);
            int[][] Maux = new int[img.getH()][img.getW()];
            int[][] M = img.getImgPGM();
            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    int p = Math.round(M[i][j] * m);
                    Maux[i][j] = p > 255 ? 255 : p;
                }
            }
            aux.setImgPGM(Maux);
            return aux;
        }
        if (img.getT() == 3) {
            Imagem aux = new Imagem(img);
            int[][][] Maux = new int[img.getH()][img.getW()][3];
            int[][][] M = img.getImgPPM();
            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    for (int k = 0; k < 3; k++) {
                        int p = Math.round(M[i][j][k] * m);
                        Maux[i][j][k] = p > 255 ? 255 : p;
                    }
                }
            }
            aux.setImgPPM(Maux);
            return aux;
        }
        return null;
    }

    public static Imagem EscurecerSub(Imagem img, int s) {
        if (s < 1) {
            return null;
        }
        if (img.getT() == 2) {
            Imagem aux = new Imagem(img);
            int[][] Maux = new int[img.getH()][img.getW()];
            int[][] M = img.getImgPGM();
            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    int p = M[i][j] - s;
                    Maux[i][j] = p < 0 ? 0 : p;
                }
            }
            aux.setImgPGM(Maux);
            return aux;
        }
        if (img.getT() == 3) {
            Imagem aux = new Imagem(img);
            int[][][] Maux = new int[img.getH()][img.getW()][3];
            int[][][] M = img.getImgPPM();
            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    for (int k = 0; k < 3; k++) {
                        int p = M[i][j][k] - s;
                        Maux[i][j][k] = p < 0 ? 0 : p;
                    }
                }
            }
            aux.setImgPPM(Maux);
            return aux;
        }
        return null;
    }

    public static Imagem EscurecerDiv(Imagem img, float d) {
        if (d <= 0) {
            return null;
        }
        if (img.getT() == 2 && d != 0) {
            Imagem aux = new Imagem(img);
            int[][] Maux = new int[img.getH()][img.getW()];
            int[][] M = img.getImgPGM();
            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    int p = Math.round(M[i][j] / d);
                    Maux[i][j] = p < 0 ? 0 : p;
                }
            }
            aux.setImgPGM(Maux);
            return aux;
        }
        if (img.getT() == 3) {
            Imagem aux = new Imagem(img);
            int[][][] Maux = new int[img.getH()][img.getW()][3];
            int[][][] M = img.getImgPPM();
            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    for (int k = 0; k < 3; k++) {
                        int p = Math.round(M[i][j][k] / d);
                        Maux[i][j][k] = p < 0 ? 0 : p;
                    }
                }
            }
            aux.setImgPPM(Maux);
            return aux;
        }
        return null;
    }

    public static Imagem binarizacao(Imagem img, int limiar) {
        if (img.getT() == 2) {
            Imagem aux = new Imagem(img);
            int[][] Maux = new int[img.getH()][img.getW()];
            int[][] M = img.getImgPGM();
            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    if (M[i][j] <= limiar) {
                        Maux[i][j] = 0;
                    } else {
                        Maux[i][j] = 255;
                    }
                }
            }
            aux.setImgPGM(Maux);
            return aux;
        }
        return null;
    }

    public static Imagem espelhar(Imagem img) {
        Imagem aux = new Imagem(img);
        switch (img.getT()) {
            case 1:
                char[][] MC = img.getImgPBM();
                char[][] MCaux = new char[img.getH()][img.getW()];
                for (int i = 0; i < img.getH(); i++) {
                    for (int j = 0; j < img.getW(); j++) {
                        MCaux[i][img.getW() - 1 - j] = MC[i][j];
                    }
                }
                aux.setImgPBM(MCaux);
                break;
            case 2:
                int[][] M = img.getImgPGM();
                int[][] Maux = new int[img.getH()][img.getW()];
                for (int i = 0; i < img.getH(); i++) {
                    for (int j = 0; j < img.getW(); j++) {
                        Maux[i][img.getW() - 1 - j] = M[i][j];
                    }
                }
                aux.setImgPGM(Maux);
                break;

            case 3:
                int[][][] MP = img.getImgPPM();
                int[][][] MPaux = new int[img.getH()][img.getW()][3];
                for (int i = 0; i < img.getH(); i++) {
                    for (int j = 0; j < img.getW(); j++) {
                        for (int k = 0; k < 3; k++) {
                            MPaux[i][img.getW() - 1 - j][k] = MP[i][j][k];
                        }
                    }
                }
                aux.setImgPPM(MPaux);
                break;
        }
        return aux;
    }

    public static Imagem rotacionar90Esquerda(Imagem img) {
        Imagem aux = new Imagem(img);
        switch (img.getT()) {
            case 1:
                char[][] MC = img.getImgPBM();
                char[][] MCaux = new char[img.getW()][img.getH()];
                for (int i = 0; i < img.getH(); i++) {
                    for (int j = 0; j < img.getW(); j++) {
                        MCaux[(img.getW() - 1) - j][i] = MC[i][j];
                    }
                }
                aux.setImgPBM(MCaux);
                break;

            case 2:
                int[][] M = img.getImgPGM();
                int[][] Maux = new int[img.getW()][img.getH()];
                for (int i = 0; i < img.getH(); i++) {
                    for (int j = 0; j < img.getW(); j++) {
                        Maux[(img.getW() - 1) - j][i] = M[i][j];
                    }
                }
                aux.setImgPGM(Maux);
                break;

            case 3:
                int[][][] MP = img.getImgPPM();
                int[][][] MPaux = new int[img.getW()][img.getH()][3];
                for (int i = 0; i < img.getH(); i++) {
                    for (int j = 0; j < img.getW(); j++) {
                        for (int k = 0; k < 3; k++) {
                            MPaux[(img.getW() - 1) - j][i][k] = MP[i][j][k];
                        }
                    }
                }
                aux.setImgPPM(MPaux);
                break;
        }
        int a = aux.getW();
        aux.setW(img.getH());
        aux.setH(a);
        return aux;
    }

    public static Imagem rotacionar90Direita(Imagem img) {
        Imagem aux = new Imagem(img);
        switch (img.getT()) {
            case 1:
                char[][] MC = img.getImgPBM();
                char[][] MCaux = new char[img.getW()][img.getH()];
                for (int i = 0; i < img.getH(); i++) {
                    for (int j = 0; j < img.getW(); j++) {
                        MCaux[j][(img.getH() - 1) - i] = MC[i][j];
                    }
                }
                aux.setImgPBM(MCaux);
                break;

            case 2:
                int[][] M = img.getImgPGM();
                int[][] Maux = new int[img.getW()][img.getH()];
                for (int i = 0; i < img.getH(); i++) {
                    for (int j = 0; j < img.getW(); j++) {
                        Maux[j][(img.getH() - 1) - i] = M[i][j];
                    }
                }
                aux.setImgPGM(Maux);
                break;
            case 3:
                int[][][] MP = img.getImgPPM();
                int[][][] MPaux = new int[img.getW()][img.getH()][3];
                for (int i = 0; i < img.getH(); i++) { //     linhas
                    for (int j = 0; j < img.getW(); j++) {//  colunas
                        for (int k = 0; k < 3; k++) {
                            MPaux[j][(img.getH() - 1) - i][k] = MP[i][j][k];
                        }
                    }
                }
                aux.setImgPPM(MPaux);
                break;
        }
        int a = aux.getW();
        aux.setW(aux.getH());
        aux.setH(a);

        return aux;
    }

    public static Imagem filtroLaplaciano(Imagem img, int filtro) {

        Imagem aux = new Imagem(img);
        int[][] masc = mascara(filtro);
        if (masc == null) {
            return null;
        }
        if (img.getT() == 2) {
            float p;
            int[][] M = img.getImgPGM();
            int[][] Maux = new int[img.getH()][img.getW()];
            for (int i = 0; i < img.getH(); i = i + 1) {
                for (int j = 0; j < img.getW(); j = j + 1) {
                    p = 0;
                    for (int k = -1; k < 2; k++) {
                        int x = (i + k) >= img.getH() ? img.getH() - 1 : (i + k) < 0 ? 0 : (i + k);
                        for (int l = -1; l < 2; l++) {
                            int y = (j + l) >= img.getW() ? img.getW() - 1 : (j + l) < 0 ? 0 : (j + l);
                            p += masc[k + 1][l + 1] * M[x][y];
                        }
                        if (p > 255) {
                            break;
                        }
                    }
                    Maux[i][j] = Math.round(p > 255 ? 255 : p < 0 ? 0 : p);
                }
            }
            aux.setImgPGM(Maux);
            return aux;
        }
        if (img.getT() == 3) {
            float p;
            int[][][] M = img.getImgPPM();
            int[][][] Maux = new int[img.getH()][img.getW()][3];
            for (int h = 0; h < 3; h++) {
                for (int i = 0; i < img.getH(); i = i + 1) {
                    for (int j = 0; j < img.getW(); j = j + 1) {
                        p = 0;
                        for (int k = -1; k < 2; k++) {
                            int x = (i + k) >= img.getH() ? img.getH() - 1 : (i + k) < 0 ? 0 : (i + k);
                            for (int l = -1; l < 2; l++) {
                                int y = (j + l) >= img.getW() ? img.getW() - 1 : (j + l) < 0 ? 0 : (j + l);
                                p += masc[k + 1][l + 1] * M[x][y][h];
                            }
                            if (p > 255) {
                                break;
                            }
                        }
                        Maux[i][j][h] = Math.round(p > 255 ? 255 : p < 0 ? 0 : p);
                    }
                }
            }
            aux.setImgPPM(Maux);
            return aux;
        }
        return null;
    }

    public static Imagem filtroMedia(Imagem img, int tMasc) {

        if (img.getT() == 2) {
            Imagem aux = new Imagem(img);
            int[][] M = img.getImgPGM();
            int[][] Maux = new int[img.getH()][img.getW()];
            int up = (tMasc + 1) / 2;

            for (int i = 0; i < img.getH(); i = i + 1) {
                for (int j = 0; j < img.getW(); j = j + 1) {
                    float media = 0;
                    for (int k = -(up - 1); k < up; k++) {
                        int x = (i + k) > img.getH() - 1 ? img.getH() - 1 : (i + k) < 0 ? 0 : (i + k);
                        for (int l = -(up - 1); l < up; l++) {
                            int y = (j + l) > img.getW() - 1 ? img.getW() - 1 : (j + l) < 0 ? 0 : (j + l);
                            media += M[x][y];
                        }
                    }
                    int result = Math.round(media / (tMasc * tMasc));
                    Maux[i][j] = result <= 255 ? result : 255;
                }
            }
            aux.setImgPGM(Maux);
            return aux;
        }
        if (img.getT() == 3) {
            Imagem aux = new Imagem(img);
            int[][][] M = img.getImgPPM();
            int[][][] Maux = new int[img.getH()][img.getW()][3];
            int up = (tMasc + 1) / 2;
            for (int h = 0; h < 3; h++) {
                for (int i = 0; i < img.getH(); i = i + 1) {
                    for (int j = 0; j < img.getW(); j = j + 1) {
                        float media = 0;
                        for (int k = -(up - 1); k < up; k++) {
                            int x = (i + k) > img.getH() - 1 ? img.getH() - 1 : (i + k) < 0 ? 0 : (i + k);
                            for (int l = -(up - 1); l < up; l++) {
                                int y = (j + l) > img.getW() - 1 ? img.getW() - 1 : (j + l) < 0 ? 0 : (j + l);
                                media += M[x][y][h];
                            }
                        }
                        int result = Math.round(media / (tMasc * tMasc));
                        Maux[i][j][h] = result <= 255 ? result : 255;
                    }
                }
            }
            aux.setImgPPM(Maux);
            return aux;
        }
        return null;
    }

    public static Imagem replicacao(Imagem img, int vzs) {

        Imagem aux = null;
        if (img.getT() == 2) {              // IMAGEM PGM
            aux = new Imagem(img);
            int[][] imgRep = new int[aux.getH() * vzs][aux.getW() * vzs];
            int[][] M = img.getImgPGM();
            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    for (int v = 0; v < vzs; v++) {
                        for (int k = 0; k < vzs; k++) {
                            imgRep[(i * vzs) + v][(j * vzs) + k] = M[i][j];
                        }
                    }
                }
            }
            aux.setH(img.getH() * vzs);
            aux.setW(img.getW() * vzs);
            aux.setImgPGM(imgRep);
        } else if (img.getT() == 3) {              // IMAGEM PPM
            aux = new Imagem(img);
            int[][][] imgRep = new int[aux.getH() * vzs][aux.getW() * vzs][3];
            int[][][] M = img.getImgPPM();
            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    for (int v = 0; v < vzs; v++) {
                        for (int k = 0; k < vzs; k++) {
                            imgRep[(i * vzs) + v][(j * vzs) + k] = M[i][j];
                        }
                    }
                }
            }
            aux.setH(img.getH() * vzs);
            aux.setW(img.getW() * vzs);
            aux.setImgPPM(imgRep);
        }
        return aux;
    }

    public static Imagem redução(Imagem img, int vzs) {
        Imagem aux = null;

        if (img.getT() == 2) {              // IMAGEM PGM
            System.out.println("caiu1");
            aux = new Imagem(img);
            aux.setH(img.getH() / vzs);
            aux.setW(img.getW() / vzs);
            int[][] imgRep = new int[aux.getH()][aux.getW()];
            int[][] M = img.getImgPGM();
            int media;
            for (int i = 0; i < aux.getH(); i++) {
                for (int j = 0; j < aux.getW(); j++) {
                    media = 0;
                    for (int v = 0; v < vzs; v++) {
                        for (int k = 0; k < vzs; k++) {
                            media += M[(i * vzs) + v][(j * vzs) + k];
                        }
                    }
                    imgRep[i][j] = media / (vzs * vzs);
                }
            }
            aux.setImgPGM(imgRep);
        } else if (img.getT() == 3) {              // IMAGEM PPM
            aux = new Imagem(img);
            aux.setH(img.getH() / vzs);
            aux.setW(img.getW() / vzs);
            int[][][] imgRep = new int[aux.getH()][aux.getW()][3];
            int[][][] M = img.getImgPPM();
            for (int i = 0; i < aux.getH(); i++) {
                for (int j = 0; j < aux.getW(); j++) {
                    int[] media = {0, 0, 0};
                    for (int l = 0; l < 3; l++) {
                        for (int v = 0; v < vzs; v++) {
                            for (int k = 0; k < vzs; k++) {
                                media[l] += M[(i * vzs) + v][(j * vzs) + k][l];
                            }
                        }
                        media[l] = media[l] / (vzs * vzs);
                    }
                    imgRep[i][j] = media;
                }
            }

            aux.setImgPPM(imgRep);
        }
        return aux;
    }

    public static Imagem equalizacaoHistograma(Imagem img) {
        if (img.getT() == 2) {
            Imagem aux = new Imagem(img);

            int[][] M = img.getImgPGM();
            int[][] Maux = new int[img.getH()][img.getW()];
            int[] ht = histogramaT(img);

            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    Maux[i][j] = ht[M[i][j]];
                }
            }
            aux.setImgPGM(Maux);
            return aux;
        }

        if (img.getT() == 3) {
            Imagem aux = new Imagem(img);
            int[][][] M = img.getImgPPM();

            int[][][] Maux = new int[img.getH()][img.getW()][3];
            int[][] MauxR = new int[img.getH()][img.getW()];
            int[][] MauxG = new int[img.getH()][img.getW()];
            int[][] MauxB = new int[img.getH()][img.getW()];

            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    MauxR[i][j] = M[i][j][0];
                    MauxG[i][j] = M[i][j][1];
                    MauxB[i][j] = M[i][j][2];
                }
            }
            Imagem a = new Imagem(img);
            a.setT((short) 2);
            a.setImgPGM(MauxR);
            int[] htr = histogramaT(a);
            a.setImgPGM(MauxG);
            int[] htg = histogramaT(a);
            a.setImgPGM(MauxB);
            int[] htb = histogramaT(a);

            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    Maux[i][j][0] = htr[M[i][j][0]];
                    Maux[i][j][1] = htg[M[i][j][1]];
                    Maux[i][j][2] = htb[M[i][j][2]];
                }
            }
            aux.setImgPPM(Maux);
            return aux;
        }
        return null;
    }

    public static Imagem equalizacaoLocal(Imagem img, int tMasc) {
        if ((tMasc / 2) == 0) {
            return null;
        }
        int pula = (tMasc + 1) / 2;
        float media = 0;
        int[][] masc = new int[tMasc][tMasc];

        if (img.getT() == 2) {
            Imagem aux = new Imagem(img);
            int[][] M = img.getImgPGM();
            int[][] Maux = new int[img.getH()][img.getW()];

            for (int i = 0; i < img.getH(); i = i + 1) {
                for (int j = 0; j < img.getW(); j = j + 1) {
                    //  l e k fazem a movimentacao encima da mascara
                    for (int k = -(pula - 1); k < pula; k++) {
                        // se (i+k) for maior que o limite superior da imagem utiliza o valor maximo de i
                        // o mesmo se for menor que zero recebe o valor do limeite menor( 0 )     
                        // o mesmo para (j+l);
                        int c = (i + k) > img.getH() - 1 ? img.getH() - 1 : (i + k) < 0 ? 0 : (i + k);
                        for (int l = -(pula - 1); l < pula; l++) {
                            int v = (j + l) > img.getW() - 1 ? img.getW() - 1 : (j + l) < 0 ? 0 : (j + l);
                            masc[k + (pula - 1)][l + (pula - 1)] = M[c][v];
                        }
                    }
//                apos obter os valores da mascara, ela é passada para a funcao que calcula a media e
//                o desvio padrao apenas daquela area
                    int result = eqLocal(masc, tMasc, M[i][j]);
                    Maux[i][j] = result > 255 ? 255 : result < 0 ? 0 : result;
                }
            }
            aux.setImgPGM(Maux);
            return aux;
        }
        if (img.getT() == 3) {
            Imagem aux = new Imagem(img);
            int[][][] M = img.getImgPPM();
            int[][][] Maux = new int[img.getH()][img.getW()][3];

            for (int h = 0; h < 3; h++) {
                for (int i = 0; i < img.getH(); i = i + 1) {
                    for (int j = 0; j < img.getW(); j = j + 1) {
                        for (int k = -(pula - 1); k < pula; k++) {
                            int c = (i + k) > img.getH() - 1 ? img.getH() - 1 : (i + k) < 0 ? 0 : (i + k);
                            for (int l = -(pula - 1); l < pula; l++) {
                                int v = (j + l) > img.getW() - 1 ? img.getW() - 1 : (j + l) < 0 ? 0 : (j + l);
                                masc[k + (pula - 1)][l + (pula - 1)] = M[c][v][h];
                            }
                        }
                        int result = eqLocal(masc, tMasc, M[i][j][h]);
                        Maux[i][j][h] = result > 255 ? 255 : result < 0 ? 0 : result;
                    }
                }
            }
            aux.setImgPPM(Maux);
            return aux;
        }
        return null;
    }

    public static Imagem estatisticaDHistograma(Imagem img, float E, float K0, float K1, float K2, int tMasc) {
        if (img.getT() != 2) {
            return null;
        }

        Imagem aux = new Imagem(img);
        int[][] M = img.getImgPGM();
        int[][] Maux = new int[img.getH()][img.getW()];

        float MG = media(M, img.getH(), img.getW());
        float DPG = desvioPadrao(M, img.getH(), img.getW(), MG);
        float MS, DPS;
        int[][] masc = new int[tMasc][tMasc];

        int p = (tMasc + 1) / 2;
        for (int i = 0; i < img.getH(); i++) {
            for (int j = 0; j < img.getW(); j++) {

                for (int k = -(p - 1); k < p; k++) {
                    int c = (i + k) > img.getH() - 1 ? img.getH() - 1 : (i + k) < 0 ? 0 : (i + k);
                    for (int l = -(p - 1); l < p; l++) {
                        int v = (j + l) > img.getW() - 1 ? img.getW() - 1 : (j + l) < 0 ? 0 : (j + l);
                        masc[k + p - 1][l + p - 1] = M[c][v];
                    }
                }
                // CALCULA A MEDIA E DESVIO PADRAO DOS VALORES EM MASC, DE UMA AREA DA IMAGEM.
                MS = media(masc, tMasc, tMasc);
                DPS = desvioPadrao(masc, tMasc, tMasc, MS);
                if (MS <= (K0 * MG) && ((K1 * DPG) <= DPS && DPS <= (K2 * DPG))) {
                    Maux[i][j] = Math.round(E * M[i][j]);
                } else {
                    Maux[i][j] = M[i][j];
                }
            }
        }

        aux.setImgPGM(Maux);
        return aux;
    }

    /* SOMA DUAS IMGENS PIXEL A PIXEL,OU COR A COR. */
    public static Imagem somarIMG(Imagem img, Imagem img2) {
        if (img.getH() != img2.getH() || img.getW() != img2.getW() || img.getT() != img2.getT()) {
            return null;
        }
        Imagem aux = new Imagem(img);
        if (img.getT() == 2) {
            aux = new Imagem(img);
            int[][] M2 = img2.getImgPGM();
            int[][] M = img.getImgPGM();
            int[][] Maux = new int[img.getH()][img.getW()];
            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    int h = (M[i][j] + (M2[i][j]));
                    h = h > 255 ? 255 : h < 0 ? 0 : h;
                    Maux[i][j] = h;
                }
            }
            aux.setImgPGM(Maux);
        } else if (img.getT() == 3) {
            aux = new Imagem(img);
            int[][][] M2 = img2.getImgPPM();
            int[][][] M = img.getImgPPM();
            int[][][] Maux = new int[img.getH()][img.getW()][3];
            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    for (int k = 0; k < 3; k++) {
                        int h = (M[i][j][k] + (M2[i][j][k]));
                        h = h > 255 ? 255 : h < 0 ? 0 : h;
                        Maux[i][j][k] = h;
                    }
                }
            }
            aux.setImgPPM(Maux);
        }
        return aux;
    }

    /* SUBTRAI DUAS IMGENS PIXEL A PIXEL,OU COR A COR. */
    public static Imagem SubtrairIMG(Imagem img, Imagem img2) {
        // AS IMAGENS DEVEM TER A MESMA ALTURA E LARGURA E SEREM DO MESMO TIPO
        if (img.getH() != img2.getH() || img.getW() != img2.getW() || img.getT() != img2.getT()) {
            return null;
        }
        Imagem aux = new Imagem(img);
        if (img.getT() == 2) {
            aux = new Imagem(img);
            int[][] M2 = img2.getImgPGM();
            int[][] M = img.getImgPGM();
            int[][] Maux = new int[img.getH()][img.getW()];

            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    int h = Math.abs(M[i][j] - (M2[i][j]));
                    h = h > 255 ? 255 : h < 0 ? 0 : h;
                    Maux[i][j] = h;
                }
            }
            aux.setImgPGM(Maux);
        } else if (img.getT() == 3) {
            aux = new Imagem(img);
            int[][][] M2 = img2.getImgPPM();
            int[][][] M = img.getImgPPM();
            int[][][] Maux = new int[img.getH()][img.getW()][3];

            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    for (int k = 0; k < 3; k++) {
                        int h = Math.abs(M[i][j][k] - (M2[i][j][k]));
                        h = h > 255 ? 255 : h < 0 ? 0 : h;
                        Maux[i][j][k] = h;
                    }
                }
            }
            aux.setImgPPM(Maux);
        }
        return aux;
    }

    /* Aplica uma correçao 'Gama',pix^gama, Para cada pixel.*/
    public static Imagem gama(Imagem img, float gama) {
        Imagem aux = null;
        if (img.getT() == 2) {
            aux = new Imagem(img);
            int c = 1;
            int[][] M = img.getImgPGM();
            int[][] Maux = new int[img.getH()][img.getW()];

            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    double p = M[i][j] / 255.0;
                    Maux[i][j] = (int) (Math.round(c * Math.pow((double) p, gama) * 255));
                    Maux[i][j] = Maux[i][j] > 255 ? 255 : Maux[i][j] < 0 ? 0 : Maux[i][j];
                }
            }
            aux.setImgPGM(Maux);
        } else if (img.getT() == 3) {
            aux = new Imagem(img);
            int c = 1;
            int[][][] M = img.getImgPPM();
            int[][][] Maux = new int[img.getH()][img.getW()][3];

            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    for (int k = 0; k < 3; k++) {
                        int p = (int) Math.round(c * Math.pow((double) M[i][j][k] / 255.0, gama) * 255);
                        Maux[i][j][k] = p > 255 ? 255 : p < 0 ? 0 : p;
                    }
                }
            }
            aux.setImgPPM(Maux);
        }
        return aux;
    }

    public static Imagem AumentarCor(Imagem img, int cor, int valor) {
        if (img.getT() != 3) {
            return null;
        }
        Imagem aux = new Imagem(img);
        int[][][] MP = img.getImgPPM();
        int[][][] MPaux = new int[img.getH()][img.getW()][3];

        for (int i = 0; i < img.getH(); i++) {
            for (int j = 0; j < img.getW(); j++) {
                for (int k = 0; k < 3; k++) {
                    if (k == cor) {
                        int p = MP[i][j][cor] + valor;
                        MPaux[i][j][cor] = p > 255 ? 255 : p;
                    } else {
                        MPaux[i][j][k] = MP[i][j][k];
                    }
                }
            }
        }
        aux.setImgPPM(MPaux);
        return aux;
    }

    public static Imagem DiminuirCor(Imagem img, int cor, int valor) {
        if (img.getT() != 3) {
            return null;
        }
        Imagem aux = new Imagem(img);
        int[][][] MP = img.getImgPPM();
        int[][][] MPaux = new int[img.getH()][img.getW()][3];

        for (int i = 0; i < img.getH(); i = i + 1) {
            for (int j = 0; j < img.getW(); j = j + 1) {
                for (int k = 0; k < 3; k = k + 1) {
                    if (k == cor) {
                        int p = MP[i][j][cor] - valor;
                        MPaux[i][j][cor] = p < 0 ? 0 : p;
                    } else {
                        MPaux[i][j][k] = MP[i][j][k];
                    }
                }
            }
        }
        aux.setImgPPM(MPaux);
        return aux;
    }

    public static Imagem ExtrairCanalRGB(Imagem img, int canal) {
        if (img.getT() != 3) {
            return null;
        }
        int[][][] MP = img.getImgPPM();
        int[][] Maux = new int[img.getH()][img.getW()];

        for (int i = 0; i < img.getH(); i = i + 1) {
            for (int j = 0; j < img.getW(); j = j + 1) {
                Maux[i][j] = MP[i][j][canal];
            }
        }
        Imagem aux = new Imagem(img);

        aux.setT((short) 2);
        aux.setImgPGM(Maux);

        return aux;
    }

    public static Imagem ExtrairCanalCMY(Imagem img, int canal) {
        if (img.getT() != 3) {
            return null;
        }
        int[][][] MP = img.getImgPPM();
        int[][] Maux = new int[img.getH()][img.getW()];

        for (int i = 0; i < img.getH(); i = i + 1) {
            for (int j = 0; j < img.getW(); j = j + 1) {
                Maux[i][j] = 255 - MP[i][j][canal];
            }
        }
        Imagem aux = new Imagem(img);

        aux.setT((short) 2);
        aux.setImgPGM(Maux);

        return aux;
    }

    public static Imagem ExtrairCanalHSI(Imagem img, int canal) {
        if (img.getT() != 3) {
            return null;
        }
        int[][][] MP = img.getImgPPM();
        int[][] Maux = new int[img.getH()][img.getW()];

        if (canal == 2) {//             Intensidade
            int D = 3 * 255,
                    N;
            for (int i = 0; i < img.getH(); i = i + 1) {
                for (int j = 0; j < img.getW(); j = j + 1) {
                    N = 0;
                    for (int k = 0; k < 3; k++) {
                        N += MP[i][j][k];
                    }
                    Maux[i][j] = N / D;
                }
            }
        } else {
            float R, G, B, r, g, b, D;
            if (canal == 1) { ///          Saturação
                for (int i = 0; i < img.getH(); i = i + 1) {
                    for (int j = 0; j < img.getW(); j = j + 1) {

                        R = (float) ((float) MP[i][j][0] / 255.0);
                        G = (float) ((float) MP[i][j][1] / 255.0);
                        B = (float) ((float) MP[i][j][2] / 255.0);
                        D = R + G + B;

                        r = R / D;
                        g = G / D;
                        b = B / D;

                        Maux[i][j] = Math.round(255 * (1 - (3 * menor(r, g, b))));
                    }
                }
            } else { //                   Matiz
                for (int i = 0; i < img.getH(); i = i + 1) {
                    for (int j = 0; j < img.getW(); j = j + 1) {
                        R = (float) ((float) MP[i][j][0] / 255.0);
                        G = (float) ((float) MP[i][j][1] / 255.0);
                        B = (float) ((float) MP[i][j][2] / 255.0);
                        D = R + G + B;

                        r = R / D;
                        g = G / D;
                        b = B / D;

                        float N;
                        N = (float) (0.5 * ((r - g) + (r - b)));
                        D = ((r - g) * (r - g)) + ((r - b) * (g - b));
                        D = (float) Math.sqrt(D);
                        N = (float) Math.acos(N / D);

                        if (b > g) {
                            N = 360 - N;
                        }
                        Maux[i][j] = Math.round(255 * N);
                    }
                }

            }
        }
        for (int i = 0; i < img.getH(); i = i + 1) {
            for (int j = 0; j < img.getW(); j = j + 1) {
                Maux[i][j] = 255 - MP[i][j][canal];
            }
        }

        Imagem aux = new Imagem(img);

        aux.setT((short) 2);
        aux.setImgPGM(Maux);
        return aux;
    }

    // mistura os canais RGB colocando os valores de um em outro
    public static Imagem misturarCanais(Imagem img, int c1, int c2, int c3) {
        if (img.getT() != 3) {
            return null;
        }
        int[][][] MP = img.getImgPPM();
        int[][][] MPaux = new int[img.getH()][img.getW()][3];
        Imagem aux = new Imagem(img);
        for (int i = 0; i < img.getH(); i = i + 1) {
            for (int j = 0; j < img.getW(); j = j + 1) {
                MPaux[i][j][0] = MP[i][j][c1];
                MPaux[i][j][1] = MP[i][j][c2];
                MPaux[i][j][2] = MP[i][j][c3];
            }
        }
        aux.setImgPPM(MPaux);
        return aux;
    }

    private static float menor(float n1, float n2, float n3) {
        if (n1 < n2) {
            if (n1 < n3) {
                return n1;
            } else {
                return n3;
            }
        } else if (n2 < n3) {
            return n2;
        } else {
            return n3;
        }
    }

    private static float media(int[][] M, int h, int w) {
        int media = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                media += M[i][j];
            }
        }
        return media / ((float) (h * w));
    }

    private static float desvioPadrao(int[][] M, int h, int w, float media) {
        float dp = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                dp += Math.pow((M[i][j] - media), 2);
            }
        }
        dp /= (h * w);
        return (float) Math.sqrt(dp);
    }

    /* calcula a equalizacao apenas para o valor em pix com os valores passado em l */
    private static int eqLocal(int[][] l, int t, int pix) {
        int[] h = new int[256];
        int[] sk = new int[256];
        float tam = t * t;
        int nc = 255;//h.length - 1;
        float acum = 0;
        int cont = 0;
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                if (l[i][j] <= pix) {
                    cont++;
                }
            }
        }
        return Math.round(nc * (cont / tam));
    }

    private static int[] histogramaT(Imagem img) {
        int[] h = img.getHistograma();  // recebe o histograma da propria imagem
        int[] sk = new int[h.length];
        float tam = img.getH() * img.getW();
        int nc = h.length - 1;
        float acum = 0;

        for (int i = 0; i < h.length; i++) {
            acum += (h[i] / tam);
            sk[i] = Math.round(nc * acum);
        }
        return sk;
    }

    private static int[][] mascara(int t) {
        int[][] masc = null;
        switch (t) {
            case 1:
                masc = new int[3][3];
//                masc[0][0] = masc[1][0] = masc[2][0] = masc[0][2] = masc[1][2] = masc[2][2] = -1;
//                masc[0][0] = masc[1][1] = masc[2][1] = 2;
                masc[0][0]
                        = masc[0][2]
                        = masc[2][0]
                        = masc[2][2] = 0;
                masc[0][1]
                        = masc[1][0]
                        = masc[1][2]
                        = masc[2][1] = -1;
                masc[1][1] = 4;
                break;
            case 2:
                masc = new int[3][3];
                masc[0][0]
                        = masc[0][2]
                        = masc[2][0]
                        = masc[2][2]
                        = masc[0][1]
                        = masc[1][0]
                        = masc[1][2]
                        = masc[2][1] = -1;
                masc[1][1] = 8;
                break;
            case 3:
                masc = new int[3][3];
                masc[0][0]
                        = masc[0][2]
                        = masc[2][0]
                        = masc[2][2] = 0;
                masc[0][1]
                        = masc[1][0]
                        = masc[1][2]
                        = masc[2][1] = 1;
                masc[1][1] = -4;
                break;

            case 4:
                masc = new int[3][3];
                masc[0][0]
                        = masc[0][2]
                        = masc[2][0]
                        = masc[2][2]
                        = masc[0][1]
                        = masc[1][0]
                        = masc[1][2]
                        = masc[2][1] = 1;
                masc[1][1] = -8;
                break;
        }
        return masc;
    }

    public static Imagem juntarCanaisRGB(Imagem img, Imagem img2, Imagem img3) {
        int h = img.getH();
        int w = img.getW();
        if (img.getT() == 2 && (img2.getT() == 2 && img2.getW() == w && img2.getH() == h)
                && (img3.getT() == 2 && img3.getW() == w && img3.getH() == h)) {
            int[][] r = img.getImgPGM(),
                    g = img2.getImgPGM(),
                    b = img3.getImgPGM();
            int[][][] aux = new int[img.getH()][img.getW()][3];

            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    aux[i][j][0] = r[i][j];
                    aux[i][j][1] = g[i][j];
                    aux[i][j][2] = b[i][j];
                }
            }

            Imagem novo = new Imagem(img);
            novo.setT((short) 3);
            novo.setImgPGM(null);
            novo.setImgPPM(aux);
            return novo;
        }
        return null;
    }

    public static Imagem pseudoCores(Imagem img, Color[] cores, int[] limites) {
        if (cores.length + 1 != limites.length) {
            return null;
        }
        // ORDENA O VETOR DE LIMITES JUNTO COM O DE CORES
        while (true) {
            int k = 0;
            for (int i = 0; i < limites.length - 1; i++) {
                if (limites[i] > limites[i + 1]) {
                    int aux = limites[i];
                    limites[i] = limites[i + 1];
                    limites[i + 1] = aux;

                    Color a = cores[i];
                    cores[i] = cores[i + 1];
                    cores[i + 1] = a;

                    k = 1;
                }
            }
            if (k == 0) {
                break;
            }
        }
        int[][][] aux = new int[img.getH()][img.getW()][3];
        // PERCORRE A IMAGEM ANALISANDO A QUAL INTERVALO I PIXEL PERTENCE
        for (int i = 0; i < img.getH(); i++) {
            for (int j = 0; j < img.getW(); j++) {
                int p = img.getImgPGM()[i][j];
                for (int l = 1; l < limites.length; l++) {
                    if (p <= limites[l]) {
                        aux[i][j][0] = cores[l - 1].getRed();
                        aux[i][j][1] = cores[l - 1].getGreen();
                        aux[i][j][2] = cores[l - 1].getBlue();
                        break;
                    }
                }
            }
        }

        Imagem novo = new Imagem(img);
        novo.setT((short) 3);
        novo.setImgPGM(null);
        novo.setImgPPM(aux);
        return novo;
    }

    public static Imagem negativo(Imagem img) {
        if (img.getT() == 2) {
            int[][] aux = new int[img.getH()][img.getW()];
            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    aux[i][j] = 255 - img.getImgPGM()[i][j];
                }
            }
            Imagem novo = new Imagem(img);
            novo.setT((short) 2);
            novo.setImgPGM(aux);
            return novo;
        }
        if (img.getT() == 3) {
            int[][][] aux = new int[img.getH()][img.getW()][3];
            for (int i = 0; i < img.getH(); i++) {
                for (int j = 0; j < img.getW(); j++) {
                    for (int k = 0; k < 3; k++) {
                        aux[i][j][k] = 255 - img.getImgPPM()[i][j][k];
                    }
                }
            }
            Imagem novo = new Imagem(img);
            novo.setT((short) 3);
            novo.setImgPPM(aux);
            return novo;
        }

        return null;
    }

    public static Imagem H() {

        int p, q;
        p = q = 512;
        int[][] h = new int[p][q];
        int min = 0;
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                double pi = Math.PI;
                double aux = -4 * pi * pi;
                aux *= Math.pow(((i - p / 2) * (i - p / 2) + (j - q / 2) * (j - q / 2)), 2);
                h[i][j] = (int) Math.round(aux);
                h[i][j] = h[i][j] < 0 ? 0 : h[i][j] > 255 ? 255 : h[i][j];
                if (h[i][j] < min) {
                    min = h[i][j];
                }
            }
        }
//        min = min < 0 ? (min * -1) : min;
//        System.out.println(min);
//        for (int i = 0; i < p; i++) {
//            for (int j = 0; j < q; j++) {
//                h[i][j] += min;
//                h[i][j] = h[i][j] > 255 ? 255 : h[i][j];                
//            }
//        }

        Imagem novo = new Imagem();
        novo.setH(p);
        novo.setW(q);
        novo.setTipo("P2");
        novo.setMaxPix(255);
        novo.setT((short) 2);
        novo.setImgPGM(h);
        return novo;

    }

//    public static NumComplex[] fft1d(double[] vet) {
//        double pi = 180.0;
//        double N = (double) vet.length;
//        int n = vet.length;
//        NumComplex[] res = new NumComplex[vet.length];
//
//        for (int x = 0; x < n; x++) {
//            double di = 0, dr = 0;
//            for (int u = 0; u < n; u++) {
//                double a = (-2 * u * x) / N;
//                dr += Math.cos(Math.toRadians(a * pi)) * vet[u];
//                di += Math.sin(Math.toRadians(a * pi)) * vet[u];
//                System.out.println(x + " >> " + dr + " - " + di + "i");
//            }
//            res[x] = new NumComplex(di, dr);
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.println("res[" + i + "]= " + Math.round(res[i].r) + (res[i].i < 0 ? " " : " + ") + Math.round(res[i].i) + "i");
////        }
//        return res;
//    }
//    public static double[] ifft1d(NumComplex[] vet) {
//        double pi = 180.0;
//        double N = (double) vet.length;
//        int n = vet.length;
//        NumComplex[] res = new NumComplex[vet.length];
//        double[] ires = new double[vet.length];
//
//        for (int x = 0; x < n; x++) {
//            double di = 0, dr = 0;
//            for (int u = 0; u < n; u++) {
//                double a = (2 * u * x) / N;
//                double r = Math.cos(Math.toRadians(a * pi));
//                double i = Math.sin(Math.toRadians(a * pi));
//
//                dr += (r * vet[u].r) + (-1 * (i * vet[u].i));
//                di += (r * vet[u].i) + (i * vet[u].r);
////                System.out.println(x + " >> " + dr + " - " + di + "i");
//            }
//            res[x] = new NumComplex(di / N, dr / N);
//        }
//        for (int i = 0; i < n; i++) {
////            System.out.println("res[" + i + "]= " + Math.round(res[i].r) + (res[i].i < 0 ? " " : " + ") + Math.round(res[i].i) + "i");
//            ires[i] = vet[i].r;
//        }
//        return ires;
//    }
//    public static NumComplex[][] fft2d(int[][] vet) {
//        double pi = 180.0;
//        double M = (double) vet.length;
//        double N = (double) vet[0].length;
//        int m = vet.length;
//        int n = vet[0].length;
////        System.out.println(m + "  -  " + n);
//        NumComplex[][] res = new NumComplex[vet.length][vet[0].length];
//
//        for (int x = 0; x < m; x++) {
//            for (int y = 0; y < n; y++) {
//                double di = 0, dr = 0;
//                for (int u = 0; u < m; u++) {
//                    for (int v = 0; v < n; v++) {
//                        double x1 = (x * u) / M, y1 = (y * v) / N;
//                        double a = (-2 * (x1 + y1));
//                        double r = Math.cos(Math.toRadians(a * pi));
//                        double i = Math.sin(Math.toRadians(a * pi));
//                        dr += r * (double) vet[u][v];
//                        di += i * (double) vet[u][v];
//                    }
//                }
//                res[x][y] = new NumComplex(di, dr);
//            }
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.println("res[" + ((i * n) + j) + "]= " + Math.round(res[i][j].r) + (res[i][j].i < 0 ? " " : " + ") + Math.round(res[i][j].i) + "i");
//            }
//        }
//        return res;
//    }
//
//    public static int[][] ifft2d(NumComplex[][] mtz) {
//        double pi = 180.0;
//        double M = (double) mtz.length;
//        double N = (double) mtz[0].length;
//        double MN = M * N;
//        int m = mtz.length;
//        int n = mtz[0].length;
//        NumComplex[][] res = new NumComplex[m][n];
//        int[][] ires = new int[m][n];
//
//        for (int x = 0; x < m; x++) {
//            for (int y = 0; y < n; y++) {
//                double di = 0, dr = 0;
//                for (int u = 0; u < m; u++) {
//                    for (int v = 0; v < n; v++) {
//                        double x1 = (x * u) / M, y1 = (y * v) / N;
//                        double a = (2 * (x1 + y1));
//                        double r = Math.cos(Math.toRadians(a * pi));
//                        double i = Math.sin(Math.toRadians(a * pi));
//
//                        dr += (r * mtz[u][v].r) + (-1 * i * mtz[u][v].i);
//                        di += (i * mtz[u][v].r) + (r * mtz[u][v].i);
//                    }
//                }
//                res[x][y] = new NumComplex(di / MN, dr / MN);
//            }
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.println("res[" + ((i * n) + j) + "]= " + Math.round(res[i][j].r) + (Math.round(res[i][j].i) < 0 ? " " : " + ") + Math.round(res[i][j].i) + "i");
//                ires[i][j] = (int) Math.round(res[i][j].modulo());
//            }
//        }
//        return ires;
//    }
//    public static int[][] fftVZmasc2d(int[][] img, int[][] masc) {
//        int m1 = masc.length;
//        int n1 = masc[0].length;
//        int m2 = img.length;
//        int n2 = img[0].length;
//
//        if (m1 != m2 || n1 != n2) {
//            return null;
//        }
//        System.out.println("Match");
//
//        NumComplex[][] fmasc = Transformacao.fft2d(masc);
//        System.out.println("passo furier1");
//        NumComplex[][] fimg = Transformacao.fft2d(img);
//        System.out.println("passo furier2");
//        NumComplex[][] faux = new NumComplex[m2][n2];
//
//        for (int x = 0; x < m1; x++) {
//            for (int y = 0; y < n1; y++) {
//                double r = 0;
//                double ni = 0;
//                for (int i = 0; i < m1; i++) {
//                    for (int j = 0; j < n1; j++) {
//                        r += (fimg[x][y].r * fmasc[i][j].r) + (-1 * fimg[x][y].i * fmasc[i][j].i);
//                        ni += (fimg[x][y].r * fmasc[i][j].i) + (-1 * fimg[x][y].i * fmasc[i][j].r);
//                    }
//                }
//                faux[x][y] = new NumComplex(ni, r);
//            }
//        }
//        System.out.println("passo furier3");
//        int[][] nimg = Transformacao.ifft2d(faux);
//        System.out.println("passo furier volta cabo!!!");
//        return nimg;
//    }
}
