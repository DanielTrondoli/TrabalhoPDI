/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdi.pkgfinal;

/**
 *
 * @author pc
 */
public class HelpText {

    public String text(int t) {
        String m = "";
        switch (t) {
            case 0:
                m = ("<html><center><h1>Caregar Imagem</h1></center>"
                        + "<p><h3>"
                        + "A Carregar Imagem permite que voce carregue uma imagem .ppm, .pgm ou .pbm no quadro de imagem de Entrada.<br> "
                        + "Outros formatos nao serão carregados. </h3></p>");
                break;
            case 1://  ****
                m = "<html><center><h1>Binarização</h1></center>"
                        + "<p align=\"justify\" ><h3>"
                        + "A função transformação “Binarização” vai pedir para o usuário especificar um valor de Limiar e"
                        + " todos os pixels que estiverem acima desse limiar vão receber o valor 255, branco, e os que estiverem "
                        + "abaixo vão receber 0, preto. "
                        + "Essa função funciona apenas para imagens .PGM ou em tons de cinza.  1aaaaaaaaaaaaaaaaaaaaaaaaaaa  "
                        + "</h3></p>";
                break;
            case 51:
            case 52:
            case 53:
            case 54:
                m = "<html><center><h1>Filtro Laplaciano</h1></center>"
                        + "<p align=\"justify\" ><h3>"
                        + "Segundo Gonzalez(2009), \"Como o lapladano é um operador diferendal, sua utilização realça as "
                        + "descontinuidades de intensidade em uma imagem e atenua as regiões com níveis de intensidade de "
                        + "variação mais suave. Isso tenderá a produzir imagens nas quais as linhas de borda e outras "
                        + "descontinuidades aparecerão em tons de cinza sobrepostos fundo escuro e uniforme\". <br>"
                        + "Essa função utiliza um filtro 3x3 = ";
                m += t == 51 ? "[0,-1,0; -1,4,-1; 0,-1,0]"
                        : t == 52 ? "[-1,-1,-1; -1,8,-1; -1,-1,-1]"
                                : t == 53 ? "[0,1,0; 1,-4,1; 0,1,0]" : "[1,1,1; 1,-8,1; 1,1,1]";
                m += ".<br> Somente imagens no formato PGM e PPM serão executadas."
                        + "</h3></p>";
                break;
            case 6:

                m = "<html><center><h1>Filtro da Média</h1></center>"
                        + "<p><h3>"
                        + "segundo, Gonzalez(2009), \"Ao substituir o valor de cada pixel de uma imagem pela média dos níveis de "
                        + "intensidade da vizinhança definida pela máscara, o processo resulta em uma imagem com perda da "
                        + "nitidez, ou seja, com redução das transições abruptas nas intensidades. Pelo fato de o ruído aleatório"
                        + " normalmente consistir em transições abruptas nos níveis de intensidade, a aplicação mais evidente da "
                        + "suavinção é a redução de ruído\". <br>"
                        + "Essa função utiliza um filtro NxN, com N fornecido pelo usuario<br>"
                        + "Somente imagens no formato PGM e PPM seram executadas.</h3></p>";
                break;

            case 8:
                m = "<html><center><h1>Equalização de Histograma</h1></center>"
                        + "<p><h3>"
                        + "UEssa função utiliza de uma função densidade de probabilidade (PDF) para uniformizar a distribuição "
                        + "de intensidade na imagem. O resultado é o realce do contraste. [ gonzalez, 2009] <br>"
                        + "Resumindo, Sk = T(Rk), onde Sk representa a intensidade de saida, Rk é a intensidade de "
                        + "entrada e T é a função de transformção que utiliza o histograma e o nivel de intensidade maximo "
                        + "L,por padrao tem o valor 255, para calcular a PDF.<br>"
                        + "Somente imagens no formato .PGM e .PPM seram equalizadas.</h3></p>";

                break;
            case 9:
                m = "<html><center><h1>Equalização Local</h1></center>"
                        + "<p><h3>"
                        + "Utilizando uma mascara de tamanho N, especificado pleo usuario, é definido uma vizinhança posicionando-a com "
                        + "o centro no pixel que sera alterado, essa vizinhança é tratada como uma sub imagem e é aplicada a equalização "
                        + "de histograma apenas para o pixel central. Em seguida a mascara é reposicionada, assim para toda a"
                        + " imagem.(Gonzalez, 2009)<br>"
                        + "O resultado é o realce de detalhes em pequenas areas da imagem."
                        + "Somente imagens no formato .PGM e .PPM seram equalizadas.</h3></p>";
                break;

            case 10:
                m = "<html><center><h1>Estatistica de Histograma</h1></center>"
                        + "<p><h3>"
                        + "Utilizando uma mascara de tamanho N, especificado pleo usuario, é definido uma vizinhança posicionando-a com "
                        + "o centro no pixel que sera alterado, essa vizinhança é tratada como uma subimagem. Apartir dai é "
                        + "calculado a media e o desvio padrao global, da imagem inteira, e local, da subimagem. Enseguida "
                        + "verifica-se se os valores calculados estao dentro do intervalo defino com as constantes K1, K2 e K3, "
                        + "se estiver o pixel da imagem original é multiplicado por outra constante E. (Gonzalez,2009)<br>"
                        + "Desta forma somente os pixels que estiverem dentro do intervalo definido serão alterados e então "
                        + "detalhes que não eram muito visíveis antes se tornam mais visíveis e o resto da imagem se mantem igual."
                        + "Somente imagens no formato .PGM e .PPM seram equalizadas.</h3></p>";
                break;
            case 20:
                m = "<html><center><h1>Gravar Histograma</h1></center>"
                        + "<p><h3>"
                        + "segundo, [gonzalez, 209], histograma de uma imagem digital com niéis de intensidade no intervalo [0, L-1] "
                        + "é uma função discreta h(Rk) = Nk onde Rk é o K-esimovalor de intensidade e Nk é o número de pixels da imagem "
                        + "com intensidade Rk.<br>"
                        + "Nesta Função o histograma é gravado em arquivo .txt, no mesmo diretorio da imagem, utilizando intensidades de 0 a 255.<br>"
                        + "Essa função funciona para imagens .PGM ."
                        + "</h3></p>";
                break;

            case 13:
                m = "<html><center><h1>Correção Gama</h1></center>"
                        + "<p><h3>"
                        + "A correção Gama muito utilizada para corrigir a exibição de imagens em monitores, principalmente "
                        + "quando a imagem precisa ser exibida com exatidao.<br>"
                        + "Aqui utilizamos a equação para a correção gama: S=cR^g, onde S é o pixel resultante, c uma constante "
                        + "de valor 1, R é o pixel de entreda e g o valor gama da correção. Para valores de gama acima de 1 a "
                        + "imagem escurece e para valores abaixo a imagem clareia. (Gonzalez, 2009)<br>"
                        + "Essa função funciona para Imagens .PGM e .PPM"
                        + "</h3></p>";
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            case 18:
                m = "<html><center><h1>Pseudocores</h1></center>"
                        + "<p><h3>"
                        + "Segundo, Gonzalez(2009), \"consiste na atribuição de uma cor a uma intensidade monocromática "
                        + "especifica, ou a uma faixa de intensidade\"<br>"
                        + "O Usuário primeiro informa quantas cores vai querer usar, em seguida ele escolhe a primeira cor e o "
                        + "primeiro valor de intensidade que será o primeiro intervalo,0 até esse valor. Depois a segunda cor e "
                        + "o valor limite do segundo intervalo e assim por diante até a última cor. o ultimo intervalo será do "
                        + "último valor inserido até 255.<br>"
                        + "Por exemplo: para 3 cores serão 3 intervalos de intensidade por sua vez dois valores inseridos pelo "
                        + "usuário."
                        + "</h3></p>";
                break;
            case 19:
                m = "<html><center><h1>Negativo</h1></center>"
                        + "<p><h3>"
                        + "O negativo de uma imagem é obtido obtendo a diferença entre o nivel de intencidade da imagem, L-1,"
                        + " e o pixel da imagem original. Ao reverter os niveis de cinza dessa maneira o resultado obtido é igual "
                        + "ao negativo fotográfico. Esse processo é muito utilizado para realçar detalhes claros em regioes "
                        + "predominantemente escuras. (Gonzalez, 2009)<br>"
                        + "Essa função funciona apenas para imagens .PGM"
                        + "</h3></p>";
                break;
            case 21:
                m = "<html><center><h1>Clarear por Soma</h1></center>"
                        + "<p><h3>"
                        + "Essa função soma um valor constante a todos os pixel da imagem. Assim aumentando o valor de todos "
                        + "os pixel e consequentemente clareando.<br>"
                        + "Essa função funciona para Imagens .PGM e .PPM ."
                        + "</h3></p>";
                break;
            case 211:
                m = "<html><center><h1>Clarear Multiplicacao</h1></center>"
                        + "<p><h3>"
                        + "Essa função multiplica todos os pixel da imagem por uma contante. Assim aumentando o valor de "
                        + "todos os pixel e consequentemente clareando a imagem.<br>"
                        + "Essa função funciona para Imagens .PGM e .PPM ."
                        + "</h3></p>";
                break;
            case 22:
                m = "<html><center><h1>Escurecer Subitração</h1></center>"
                        + "<p><h3>"
                        + "Essa função subtrai um valor constante a todos os pixel da imagem. Assim diminuindo o valor de todos "
                        + "os pixel e consequentemente escurecendo a imagem.<br>"
                        + "Essa função funciona para Imagens .PGM e .PPM ."
                        + "</h3></p>";
                break;
            case 221:
                m = "<html><center><h1>Escurecer Divisao</h1></center>"
                        + "<p><h3>"
                        + "Essa função divide todos os pixel da imagem por um valor constante. Assim diminuindo o valor de todos "
                        + "os pixel e consequentemente escurecendo a imagem.<br>"
                        + "Essa função funciona para Imagens .PGM e .PPM ."
                        + "</h3></p>";
                break;
        }
        return m;
    }

}
