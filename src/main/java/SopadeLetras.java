import java.util.Scanner;

public class SopadeLetras{        
        
    public static Scanner leer=new Scanner(System.in);
    public static int n; public static int max;
    public static char[][] sopa; 
    public static char[] rand={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static int puntaje;
    public static boolean partidajugada=false;
    
    public static String[][] historial=new String[10][4];public static int ctehistorial;
    public static String[][] mejorespuntuaciones={{"nombre","0"},{"nombre","0"},{"nombre","0"}};
    public static String[] jganaron=new String[10];public static  int ctejganaron;
    public static String[] jperdieron=new String[10];public static  int ctejperdieron;
    
    public static String nombre;
    
    
    public static void main(String[] args) {
        
        System.out.println("Bienvenido al Juego de Sopa de Letras.");
        
        Principal();              
    }
    
    
    public static void Principal(){
        
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("");
        System.out.println("1. Nueva Partida");
        System.out.println("2. Historial de Partidas");
        System.out.println("3. Puntuaciones Más Altas");
        System.out.println("4. Jugadores que Encontraron Todas las Palabras");
        System.out.println("5. Jugadores que No Encontraron Todas las Palabras");
        System.out.println("6. Información del Estudiante");
        System.out.println("7. Salir");
        
        int Menuprincipal=leer.nextInt();
        
        switch (Menuprincipal){
            
            case 1:
                
                System.out.println("Ingrese su nombre");    //leer nombre
                nombre=leer.next();

                boolean tamañovalido=false;
                while (tamañovalido==false){    //tamaño de la matriz
                    System.out.println("Ingrese el tamaño de la sopa de letras nxn. Debe ser mayor o igual a 10x10.");                    
                    n=leer.nextInt();
                   
                    if (n>=10)
                        tamañovalido=true;
                    else
                        System.out.println("Ingrese un tamaño válido");
                }
                
            sopa = new char[n][n];

                Partida();
                break;
                
            case 2:
                
                if(ctehistorial>0){            
                    System.out.println("HISTORIAL DE PARTIDAS");                                       
                        System.out.println("    NOMBRE    PUNTAJE    FALLOS    PALABRAS ENCONTRADAS");
                        System.out.println();
                        for (int i=1; i<=ctehistorial; i++) {
                        System.out.println(i+")  "+historial[i-1][0]+"........"+historial[i-1][1]+"........"+historial[i-1][2]+"........"+historial[i-1][3]);
                        }
                }
                else
                    System.out.println("No se ha jugado ninguna partida");
                
                Principal();                
                break;
                
            case 3:
                if(ctehistorial>0){            
                    System.out.println("PUNTUACIONES MÁS ALTAS");
                        System.out.println("    NOMBRE      PUNTAJE");
                        System.out.println();
                        for (int i=1; i<=3; i++) {
                        System.out.println(i+")  "+mejorespuntuaciones[i-1][0]+"........"+mejorespuntuaciones[i-1][1]);
                        }

                }
                else
                    System.out.println("No se ha jugado ninguna partida");        
        
                Principal();                
                break;
                
            case 4:
                
                if(ctejganaron>0){            
                    System.out.println("JUGADORES QUE GANARON");
                    System.out.println("    NOMBRE");
                    System.out.println();
                    for (int i=1; i<=ctejganaron; i++)
                    System.out.println(i+")  "+jganaron[i-1]);
                    
                }
                else
                    System.out.println("No hay datos");
                
                Principal();                
                break;
                
            case 5:
                
                if(ctejperdieron>0){            
                    System.out.println("JUGADORES QUE PERDIERON");
                    System.out.println("    NOMBRE");
                    System.out.println();
                    for (int i=1; i<=ctejperdieron; i++)
                    System.out.println(i+")  "+jperdieron[i-1]);

                }
                else
                    System.out.println("No hay datos");
                
                Principal();                
                break;
                
            case 6:
                System.out.println("................................................................");
                System.out.println("Programa elaborado por Pablo Fernando Cabrera Pineda, 201901698.");
                System.out.println("                      IPC1, Sección B.");
                System.out.println("................................................................");
                Principal();
                break;
                
            case 7:
                System.out.println("Gracias por jugar");
                System.exit(0);
                break;
                
            default:                
                System.out.println("Ingrese una opción válida");
                Principal();
                break;
                
        }
        
                
    }
    
    
    public static void Partida(){

        System.out.println("MENÚ NUEVA PARTIDA"); 
        System.out.println("");   
        System.out.println("1. Menú Palabras");
        System.out.println("2. Jugar");
        System.out.println("3. Terminar Partida");

        int Menujuego=leer.nextInt();

        switch(Menujuego){

            case 1:   
                Juego.Palabras(); 
                break;

            case 2:
                Juego.Jugar();
                break;

            case 3:
                Principal();
                break;

            default:           
                System.out.println("Ingrese una opción válida");
                Partida();
                break;
        }
    }   
    
    
    
    public static void Imprimirmatriz(char matriz[][]){
    int x,y;
        for (x=0; x <matriz.length; x++) {
            for (y=0; y <matriz[x].length; y++) {                
                System.out.print ("|"+matriz[x][y]+"| ");
            }
            System.out.println("");
        }                
    }  
}
