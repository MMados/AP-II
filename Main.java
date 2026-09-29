import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;
        String[] frutas = { "Uva", "abacaxi", "Pêra", "manga", "Caju", "maçã",
                "Laranja", "banana", "Kiwi", "limão", "Abacate", "goiaba",
                "Morango", "acerola", "Pitaya", "caqui", "Jabuticaba",
                "amora", "Framboesa", "cereja" };

        while (true) {
            System.out.printf("Qual Vetor você deseja utilizar: \n(1) Lista de frutas: \n(2) Lista de números: \n");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("Lista Desordenada de frutas: ");
                    exibirString(frutas);
                    mergeSortStr(0, frutas.length, frutas);
                    System.out.println("aaa");
                    exibirString(frutas);

                    System.out.println("Deseja pesquisar um valor especifico? (1) Sim (2) Não");
                    int pesquisar = scanner.nextInt();

                    if(pesquisar == 1){
                        System.out.println("Digite o valor que deseja pesquisar: ");
                        String valorStringPesquisa = scanner.next();

                        int indiceString = pesquisaBinariaString(valorStringPesquisa, frutas);

                        if(indiceString >= 0){
                            System.out.printf("O indice é: %d \n", indiceString);
                        } else{
                            System.out.println("Valor inexistente");
                        }
                    };
                    break;
                case 2:
                    System.out.println("Digite o tamanho da lista aleatória");
                    int tamanho = scanner.nextInt();

                    System.out.println("Digite o valor minimo que deseja sortear");
                    int valorMinimo = scanner.nextInt();

                    System.out.println("Digite o valor máximo que deseja sortear");
                    int valorMaximo = scanner.nextInt();

                    int[] numeros = new int[tamanho];

                    preencher(numeros, valorMinimo, valorMaximo);

                    break;

                default:
                    System.out.println("Por favor escolha uma opção válida");
                    break;
            }

            System.out.println("Deseja continuar o programa (1) Sim (2) Não");
            int continuar = scanner.nextInt();

            if (continuar == 2) {
                break;
            }
        }
        scanner.close();
        System.out.println("Programa encerrado!");
    }

    public static void preencher(int[] v, int valorMinimo, int valorMaximo) {
        Random rd = new Random();
        for (int i = 0; i < v.length; i++) {
            v[i] = rd.nextInt(valorMinimo, valorMaximo + 1);
        }
    }

    public static void exibir(int[] v) {
        for (int i : v) {
            System.out.println(i);
        }
    }

    public static void exibirString(String[] v) {
        for (String i : v) {
            System.out.println(i);
        }
    }

    public static void mergeSortStr(int inicio, int tamanho, String[] v) {
        if (inicio < tamanho - 1) {
            int meio = (inicio + tamanho) / 2;
            mergeSortStr(inicio, meio, v);
            mergeSortStr(meio, tamanho, v);
            intercalarStr(inicio, meio, tamanho, v);
        }
    }

    public static void intercalarStr(int inicio, int meio, int tamanho, String[] v) {
        int i, j, k;
        String[] auxiliar = new String[tamanho - inicio];
        i = inicio;
        j = meio;
        k = 0;

        while (i < meio && j < tamanho) {
            if (v[i].compareToIgnoreCase(v[j]) <= 0) {
                auxiliar[k] = v[i];
                k++;
                i++;
            } else {
                auxiliar[k] = v[j];
                k++;
                j++;
            }
        }

        while (i < meio) {
            auxiliar[k] = v[i];
            k++;
            i++;
        }

        while (j < tamanho) {
            auxiliar[k] = v[j];
            k++;
            j++;
        }

        for (i = inicio; i < tamanho; i++) {
            v[i] = auxiliar[i - inicio];
        }
    }

    public static void mergeSortInt(int inicio, int tamanho, int[] v) {
        if (inicio < tamanho - 1) {
            int meio = (inicio + tamanho) / 2;
            mergeSortInt(inicio, meio, v);
            mergeSortInt(meio, tamanho, v);
            intercalarInt(inicio, meio, tamanho, v);
        }
    }

    public static void intercalarInt(int inicio, int meio, int tamanho, int[] v) {
        int i, j, k;
        int[] auxiliar = new int[tamanho - inicio];
        i = inicio;
        j = meio;
        k = 0;

        while (i < meio && j < tamanho) {
            if (v[i] <= v[j]) {
                auxiliar[k] = v[i];
                k++;
                i++;
            } else {
                auxiliar[k] = v[j];
                k++;
                j++;
            }
        }

        while (i < meio) {
            auxiliar[k] = v[i];
            k++;
            i++;
        }

        while (j < tamanho) {
            auxiliar[k] = v[j];
            k++;
            j++;
        }

        for (i = inicio; i < tamanho; i++) {
            v[i] = auxiliar[i - inicio];
        }
    }

    public static int pesquisaBinaria(int valor, int [] v){
        int inicio=0;
        int fim=v.length-1;
        int meio;
        while (inicio <= fim) {
            meio =(fim+inicio)/2;
            if (valor == v[meio]) {
                return meio;
            }
            else if (valor > v[meio]) {
                inicio=meio+1;
            }
            else {
                fim=meio-1;
            }
        }
        return -1;
    }

    public static int pesquisaBinariaString(String valor, String[] v) {
    int inicio = 0;
    int fim = v.length - 1;
    int meio;
    
    while (inicio <= fim) {
        meio = (fim + inicio) / 2;
        int comparacao = valor.compareTo(v[meio]);
        if (comparacao == 0) {
            return meio;
        } 
        else if (comparacao > 0) {
            inicio = meio + 1;
        } 
        else {
            fim = meio - 1;
        }
    }
    return -1;
}
}