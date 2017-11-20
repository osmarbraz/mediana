/*
 * Universidade Federal de Santa Catarina - UFSC
 * Departamento de Informática e Estatística - INE
 * Programa de Pós-Graduação em Ciências da Computação - PROPG
 * Disciplinas: Projeto e Análise de Algoritmos
 * Prof Alexandre Gonçalves da Silva 
 * 
 * Cálculo da Mediana em um vetor ordenado
 *
 * Página 155 Thomas H. Cormen 3d
 * Mediana inferior com piso independente da paridade de n
 *
 * Atenção:
 * Vetor em java inicia em 0, os algoritmos consideram início em 1.
 * A subtração de -1 ocorre somente no local de acesso ao vetor ou matriz 
 * para manter a compatibilidade entre os algoritmos.
 *
 */

/**
 * @author Osmar de Oliveira Braz Junior
 */
public class Principal {

     /**
     * O piso (= floor) de um número real x é o resultado do arredondamento de x
     * para baixo. Em outras palavras, o piso de x é o único número inteiro i
     * tal que i<=x<i+1. Ex. O piso de 3.9 é 3
     *
     * Em java pode ser utilizando Math.floor(double)
     *
     * @param x Número real a ser calculado o piso.
     * @return um valor inteiro com o piso de x.
     */
    public static int piso(double x) {
        //Pego a parte inteira de x
        int parteInteira = (int) x;
        //Pego a parte fracionária de x
        double parteFracionaria = x - parteInteira;
        //Retorno x subtraindo a parte fracionária 
        return (int) (x - parteFracionaria);
    }    
        
    /**
     * Cálculo da Mediana em um conjunto ordenado.         
     *     
     * @param p Início do Vetor
     * @param r Quantidade de elementos do vetor
     * @return A posição da mediana
     */
    private static int mediana(int p, int r) {
        //Calcula a quantidade de elementos de p até r
        //p = 1 e r = 5 = 5 - 1 + 1 = 5 elementos
        //p = 6 e r = 10 = 10 - 6 + 1 = 5 elementos
        int n = r - p + 1;
        //Calcula a posição da mediana em relação a quantidade de elementos do intervalo de p até r
        int m =  piso(n / 2.0);        
        if (n % 2 == 1) {
            //Quantidade ímpar 
            //Início do vetor mais a mediana
            //p = 6 e r = 10 = 10 - 6 + 1 = 5 elementos
            //m = piso(5 / 2) = 2
            //mediana = 6 + 2 = 8
            return (p + m);
        } else {
            //Quantidade par 
            //Início do vetor mais a mediana
            //p = 5 e r = 10 = 10 - 5 + 1= 6 elementos
            //m = piso(6 / 2) = 3
            //mediana = 6 + 3 - 1 = 7
            return (p + m - 1);
        }  
    }

    public static void main(String args[]) {

        //Vetor de dados
        int A[] = {10, 20, 30, 40, 50, 60 , 70, 80, 90}; //Qtde ímpar de elementos
        //int A[] = {10, 20, 30, 40, 50, 60 , 70, 80}; //Qtde par de elementos
        
        //Quantidade de elementos
        int r = A.length;

        System.out.println(">>> Cálculo da Mediana em vetor ordenado <<<");
        System.out.println("Vetor A: ");
        for (int i = 1; i <= r; i++) {
            System.out.println((i) + " - " + A[i-1]);
        }

        //Localiza a mediana posição da mediana em um vetor ordenado
        int q = mediana(1, r);
                
        System.out.println("A mediana está na posição: " + q);        
        System.out.println("O Valor é da Mediana: " + A[q - 1]);
    }
}
