public class Juego extends SopadeLetras {
    public static boolean palabrasingresadas=false;
    public static int tam=0;
    public static boolean palabravalida;
    public static String[] Palabras=new String[0];
    public static String[] Palabrasdefault={"peine","libro","reloj","tecla","mouse","regla"};
    
    public static void Palabras(){
        
            System.out.println("MENÚ PALABRAS");
            System.out.println("");
            System.out.println("1. Insertar palabras a la sopa de letras");
            System.out.println("2. Modificar palabras de la sopa de letras");
            System.out.println("3. Eliminar palabras de la sopa de letras");
            System.out.println("4. Regresar al menú anterior");

            int Menupalabras=leer.nextInt();

            switch(Menupalabras){

                case 1:
                    palabrasingresadas=true;
                    System.out.println("¿Cuántas palabras desea ingresar? Deben ser un máximo de "+n/2+".");
                    tam=leer.nextInt();         
                    while(tam>n/2 || tam==0){
                        System.out.println("Deben ser al menos 1 y un máximo de "+n/2+".");                       
                        tam=leer.nextInt();                           
                        System.out.println();             
                    }
                    int tama=tam;
                    if(tam%2==1)
                        tam--;    
                    tam+=6;
                    
                    Palabras=new String[tam];  
                    
                    int max=n/2;          

                    if (max>10)
                        max=10;
                    
                    
                    for (int i=1; i<=tama; i++){                        
                        System.out.println("Ingresa la palabra No."+i+". Debe tener entre 5 y "+max+" caracteres.");
                        
                        palabravalida=false;
                        while (palabravalida==false){
                            Palabras[i-1]=leer.next();
                            if (Palabras[i-1].length()>=5 && Palabras[i-1].length()<=max)
                                palabravalida=true;
                            else
                                System.out.println("Ingrese una palabra válida.");
                        }
                    }                       
                    
                    for(int i=tama; i<tam;i++){
                        if(Palabras[i] == null)
                            Palabras[i]=Palabrasdefault[i-tama];
                    }
                    
                    System.out.println("Palabras ingresadas correctamente.");
                    Palabras();

                    break;

                case 2:
                    boolean palabramodificada=false;
                    if (palabrasingresadas==true){
                        System.out.println("¿Qué palabra desea modificar?");
                        String modificar=leer.next();
                        for(int i=1; i<=tam; i++){
                            if(Palabras[i-1].equalsIgnoreCase(modificar)){
                                palabramodificada=true;
                                palabravalida=false;
                                while (palabravalida==false){
                                    System.out.println("Ingrese la palabra que sustituirá a '"+modificar+"'.");
                                    String nuevapalabra=leer.next();
                                    if (nuevapalabra.length()>4 && nuevapalabra.length()<11){
                                        Palabras[i-1]=nuevapalabra;
                                        System.out.println("Palabra modificada con éxito.");
                                        palabravalida=true;
                                    }
                                    else
                                        System.out.println("Ingrese una palabra de entre 5 y 10 caracteres.");
                                }
                            }
                        }
                        if (palabramodificada==false)
                            System.out.println("No se encontró la palabra '"+modificar+"'.");
                        
                        Palabras();
                        
                    }
                    else{
                        System.out.println("No se han ingresado palabras todavía.");
                        Palabras();
                    }
                    break;

                case 3:      
                    boolean palabraeliminada=false;
                    if (palabrasingresadas==true){
                        System.out.println("¿Qué palabra desea eliminar?");
                        String eliminar=leer.next();
                        for(int i=1; i<=tam; i++){
                            if(Palabras[i-1].equalsIgnoreCase(eliminar)){
                                palabraeliminada=true;
                                        Palabras[i-1]="";
                                        System.out.println("Palabra eliminada con éxito.");
                        }
                        if (palabraeliminada==false)
                            System.out.println("No se encontró la palabra '"+eliminar+"'.");
                        
                        Palabras();
                        }    
                    }
                    else{
                        System.out.println("No se han ingresado palabras todavía.");
                        Palabras();
                    }
                    
                    break;
                    
                case 4:
                    SopadeLetras.Partida();
                    break;

                default:
                    System.out.println("Ingrese una opción válida");
                    Palabras();
                    break;
            }                             
        } 
    
    
    public static void Jugar(){
        
        if (palabrasingresadas==true){
            partidajugada=true;
            Matriz(Palabras);
        }
        else{
            System.out.println("Aún no se han ingresado palabras al juego.");
            SopadeLetras.Partida();
        }
    }
    
    public static void Matriz(String[] Palabras){
        puntaje=20;
        Incrustar();
        Incrustarver();                       
        MatrizRandom();
        
        int fallos=0;    
        boolean fallo;    
        int palabrasencontradas=0;
        while(palabrasencontradas<Palabras.length){
            fallo=true; 
            SopadeLetras.Imprimirmatriz(sopa);
            String palabra=leer.next();
            for (int i=0;i<Palabras.length;i++){
                if(palabra.equalsIgnoreCase(Palabras[i])){
                    System.out.println("Encontraste una palabra");
                    int lon=Palabras[i].length();
                    puntaje+=lon;
                    Palabras[i]="";
                    palabrasencontradas++;
                    System.out.println("Palabras encontradas: "+palabrasencontradas);
                    for (int j=0;j<lon;j++){
                        Palabras[i]=Palabras[i]+"$";
                    }
                    Incrustar();
                    Incrustarver();
                    fallo=false;
                }
            }
            if(fallo==true){
                System.out.println("Has fallado.");
                puntaje-=5;
                fallos++;
            }
            
            if(fallos==3){
                palabrasencontradas=Palabras.length;                
            }
        }
        
        
        if(puntaje>Integer.parseInt(mejorespuntuaciones[0][1])){

            mejorespuntuaciones[2][1]=mejorespuntuaciones[1][1];
            mejorespuntuaciones[1][1]=mejorespuntuaciones[0][1];                
            mejorespuntuaciones[0][1]=Integer.toString(puntaje);
     
            mejorespuntuaciones[2][0]=mejorespuntuaciones[1][0];
            mejorespuntuaciones[1][0]=mejorespuntuaciones[0][0];                
            mejorespuntuaciones[0][0]=nombre;
     
        }
        else{
            if(puntaje>Integer.parseInt(mejorespuntuaciones[1][1])){

            mejorespuntuaciones[2][1]=mejorespuntuaciones[0][1];                
            mejorespuntuaciones[1][1]=Integer.toString(puntaje);
            
            mejorespuntuaciones[2][0]=mejorespuntuaciones[0][0];                
            mejorespuntuaciones[1][0]=nombre;
     
            }
            else{                
                if(puntaje>Integer.parseInt(mejorespuntuaciones[2][1])){           
                mejorespuntuaciones[2][1]=Integer.toString(puntaje);
                
                mejorespuntuaciones[2][0]=nombre;
                }
            }
                
        }
        
        historial[ctehistorial][0]=nombre;
        historial[ctehistorial][1]=Integer.toString(puntaje);
        historial[ctehistorial][2]=Integer.toString(fallos);
        historial[ctehistorial][3]=Integer.toString(palabrasencontradas);
        ctehistorial++;
            
        if(fallos==3){
            System.out.println("No lograste encontrar todas las palabras");
            System.out.println("Puntaje: "+puntaje);
            jperdieron[ctejperdieron]=nombre;
            ctejperdieron++;
            SopadeLetras.Principal();  
        }
        else{
            System.out.println("Encontraste todas las palabras.");
            System.out.println("Puntaje: "+puntaje);
            jganaron[ctejganaron]=nombre;
            ctejganaron++;            
            SopadeLetras.Principal();
        }      
    }
    
    public static void Incrustar(){           
        for(int i=0;i<Palabras.length/2;i++){
            for (int j=0;j<Palabras[i].length();j++){
                sopa[i][j]=Palabras[i].charAt(j);
            }
        }
    }
    
    
    public static void Incrustarver(){           
        for(int i=Palabras.length/2;i<Palabras.length;i++){
            int h=(int)(Math.random()*(n/2));
            for (int j=0;j<Palabras[i].length();j++){
                sopa[n-1-j-h][n-1-i+Palabras.length/2]=Palabras[i].charAt(j);
            }
        }
    }   
    
    
    public static void MatrizRandom(){
        for(int i=0;i<sopa.length;i++){
            for (int j=0;j<sopa[i].length;j++){
                if (sopa[i][j]=='\u0000'){
                    sopa[i][j]=rand[(int)(Math.random()*54)];
                }                
            }
        }
    }  
}
