import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;

public class Main {
    private static int preguntaActual = 0;
    private static int aciertos = 0;
    private static boolean[] respondidas;
    private static JButton[] botonesOpciones;
    private static Pregunta[] preguntas;
    private static long tiempoInicial=0;
    private static String cuestion_err ="";
    
    public static void main(String[] args) throws Exception {
        tiempoInicial=System.nanoTime();
        iniciarTest();
        
    }

    public static void iniciarTest() {
    	Color verdeSuave = Color.decode("#91ecab");
    	Color rojoSuave = Color.decode("#b32641");
        preguntas = cuestionario();
        respondidas = new boolean[preguntas.length];
        preguntaActual = 0;
        aciertos = 0;

        // Crear la ventana principal
        JFrame frame = new JFrame("Simulador de Examen de Ingeniería de Software 2");
        ImageIcon icono = new ImageIcon("logoApp.png"); 
        frame.setIconImage(icono.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Panel principal para mostrar preguntas y opciones
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Etiqueta para mostrar la pregunta
        JLabel etiquetaPregunta = new JLabel("", SwingConstants.CENTER);
        etiquetaPregunta.setFont(new Font("Arial", Font.PLAIN, 20));
        etiquetaPregunta.setVerticalAlignment(SwingConstants.TOP);
        panelPrincipal.add(etiquetaPregunta, BorderLayout.NORTH);

        // Panel para las opciones
        JPanel panelOpciones = new JPanel(new GridLayout(4, 1, 10, 10));
        botonesOpciones = new JButton[4];
        for (int i = 0; i < 4; i++) {
            botonesOpciones[i] = new JButton();
            panelOpciones.add(botonesOpciones[i]);
        }
        panelPrincipal.add(panelOpciones, BorderLayout.CENTER);

        // Panel para las flechas de navegación
        JPanel panelNavegacion = new JPanel(new FlowLayout());
        JButton botonAtras = new JButton("<-");
        JButton botonSiguiente = new JButton("->");
        JButton botonFin = new JButton("Finalizar test");
        
        // Etiqueta para mostrar la pregunta
        JLabel etiquetaNum = new JLabel("", SwingConstants.CENTER);
        etiquetaNum.setFont(new Font("Arial", Font.PLAIN, 14));
        etiquetaNum.setVerticalAlignment(SwingConstants.TOP);
        panelNavegacion.add(etiquetaNum, BorderLayout.NORTH);
        
        panelNavegacion.add(botonAtras);
        panelNavegacion.add(botonSiguiente);
        panelNavegacion.add(botonFin);
        panelPrincipal.add(panelNavegacion, BorderLayout.SOUTH);

        // Añadir acciones a los botones de navegación
        botonAtras.addActionListener(e -> {
            if (preguntaActual > 0) {
                preguntaActual--;
                mostrarPregunta(etiquetaPregunta, botonesOpciones,etiquetaNum);
            }
        });

        botonSiguiente.addActionListener(e -> {
            if (preguntaActual < preguntas.length - 1) {
                preguntaActual++;
                mostrarPregunta(etiquetaPregunta, botonesOpciones,etiquetaNum);
            } else {
                int opcion = JOptionPane.showConfirmDialog(frame, "¿Quieres finalizar el test?", "Finalizar Test", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    mostrarPantallaFinal();
                }
            }
        });
        botonFin.addActionListener(e -> {
        	int opcion = JOptionPane.showConfirmDialog(frame, "¿Quieres finalizar el test?", "Finalizar Test", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                frame.dispose();
                mostrarPantallaFinal();
            }
        });
        // Añadir acciones a los botones de opciones
        for (int i = 0; i < 4; i++) {
            int indice = i;
            botonesOpciones[i].addActionListener(e -> {
                if (!respondidas[preguntaActual]) {
                    char respuestaSeleccionada = botonesOpciones[indice].getText().charAt(0);
                    preguntas[preguntaActual].setIndiceSeleccionado(indice);
                    respuestaSeleccionada=Character.toUpperCase(respuestaSeleccionada);
                    char solucionSeleccionada= Character.toUpperCase(preguntas[preguntaActual].getSolucion());
                    if (respuestaSeleccionada==solucionSeleccionada) {
                        botonesOpciones[indice].setBackground(verdeSuave);
                        preguntas[preguntaActual].setRespondidaCorrectamente(true);
                        aciertos++;
                    } else {
                        botonesOpciones[indice].setBackground(rojoSuave);
                        preguntas[preguntaActual].setRespondidaCorrectamente(false);
                        for (JButton boton : botonesOpciones) {
                            if (boton.getText().charAt(0)==preguntas[preguntaActual].getSolucion()) {
                                boton.setBackground(verdeSuave);
                                break;
                            }
                        }
                    }
                    respondidas[preguntaActual] = true;
                }
            });
        }

        // Añadir KeyBindings para flechas direccionales
        InputMap inputMap = panelPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = panelPrincipal.getActionMap();

        // Asignar acción para flecha izquierda
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
        actionMap.put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (preguntaActual > 0) {
                    preguntaActual--;
                    mostrarPregunta(etiquetaPregunta, botonesOpciones,etiquetaNum);
                }
            }
        });

        // Asignar acción para flecha derecha
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
        actionMap.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (preguntaActual < preguntas.length - 1) {
                    preguntaActual++;
                    mostrarPregunta(etiquetaPregunta, botonesOpciones,etiquetaNum);
                }
            }
        });
        
        // Mostrar la primera pregunta
        mostrarPregunta(etiquetaPregunta, botonesOpciones,etiquetaNum);

        // Configurar la ventana y mostrarla
        frame.add(panelPrincipal);
        frame.setVisible(true);

        // Finalización del test
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                int total = preguntas.length;
                JOptionPane.showMessageDialog(null, "Test finalizado. Aciertos: " + aciertos + " de " + total);
            }
        });
    }

    public static void mostrarPantallaFinal() {
    	Color verdeSuave = Color.decode("#91ecab");
    	Color rojoSuave = Color.decode("#b32641");
        long tiempoFinal = System.nanoTime();
        long tiempoTotal = tiempoFinal - tiempoInicial;

        // Cálculo del tiempo en minutos y segundos
        long minutos = tiempoTotal / 60_000_000_000L;
        long segundos = (tiempoTotal / 1_000_000_000L) % 60;

        JFrame frameFinal = new JFrame("Resultado del Test");
        ImageIcon icono = new ImageIcon("logoApp.png"); 
        frameFinal.setIconImage(icono.getImage());
        frameFinal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameFinal.setSize(400, 300);

        JPanel panel = new JPanel(new BorderLayout());

        // Calcular la nota final
        int totalPreguntas = preguntas.length;
        double notaFinal = ((aciertos - ((totalPreguntas-aciertos)*0.33))*10)/50;
        notaFinal = Math.max(0, Math.min(10, notaFinal)); // Limitar entre 0 y 10

        // Texto de aprobado o suspenso
        JLabel etiquetaEstado = new JLabel();
        etiquetaEstado.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaEstado.setFont(new Font("Arial", Font.BOLD, 20));
        if (notaFinal >= 5.0) {
            etiquetaEstado.setText("APROBADO");
            etiquetaEstado.setForeground(verdeSuave);
        } else {
            etiquetaEstado.setText("SUSPENSO");
            etiquetaEstado.setForeground(rojoSuave);
        }
        panel.add(etiquetaEstado, BorderLayout.NORTH);

        // Texto con el número de aciertos, nota y tiempo tardado
        JLabel etiquetaResultado = new JLabel(
            "<html>Aciertos: " + aciertos + " de " + totalPreguntas + 
            "<br>Nota: " + String.format("%.2f", notaFinal) + 
            "<br>Tiempo tardado: " + minutos + ":" + String.format("%02d", segundos) + 
            "</html>", 
            SwingConstants.CENTER
        );
        etiquetaResultado.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(etiquetaResultado, BorderLayout.CENTER);

        // Botón de reiniciar test
        JButton botonReiniciar = new JButton("Reiniciar Test");
        botonReiniciar.addActionListener(e -> {
            frameFinal.dispose();
            iniciarTest();
        });
        panel.add(botonReiniciar, BorderLayout.SOUTH);

        frameFinal.add(panel);
        frameFinal.setVisible(true);
    }



    public static void mostrarPregunta(JLabel etiquetaPregunta, JButton[] botonesOpciones, JLabel etiquetaNum) {
    	Color verdeSuave = Color.decode("#91ecab");
    	Color rojoSuave = Color.decode("#b32641");
        Pregunta pregunta = preguntas[preguntaActual];

        etiquetaPregunta.setText("<html>" + pregunta.getCuestion().replace("\n", "<br>") + "</html>");        
		botonesOpciones[0].setText(pregunta.getCuestion1());   
		botonesOpciones[0].setFont(new Font("Arial", Font.PLAIN, 16));
		botonesOpciones[1].setText(pregunta.getCuestion2());   
		botonesOpciones[1].setFont(new Font("Arial", Font.PLAIN, 16));
		botonesOpciones[2].setText(pregunta.getCuestion3());  
		botonesOpciones[2].setFont(new Font("Arial", Font.PLAIN, 16));
		botonesOpciones[3].setText(pregunta.getCuestion4());
		botonesOpciones[3].setFont(new Font("Arial", Font.PLAIN, 16));
		int num=preguntaActual+1;
		etiquetaNum.setText("Pregunta: "+num+"/"+preguntas.length);

        for (int i = 0; i < botonesOpciones.length; i++) {
            botonesOpciones[i].setBackground(null);
        }

        if (respondidas[preguntaActual]) {
            int seleccionado = pregunta.getIndiceSeleccionado();
            if (seleccionado != -1) {
                if (pregunta.isRespondidaCorrectamente()) {
                    botonesOpciones[seleccionado].setBackground(verdeSuave);
                } else {
                    botonesOpciones[seleccionado].setBackground(rojoSuave);
                    for (JButton boton : botonesOpciones) {
                        if (boton.getText().charAt(0)==pregunta.getSolucion()) {
                            boton.setBackground(verdeSuave);
                            break;
                        }
                    }
                }
            }
        }
    }

    public static Pregunta[] cuestionario() {
    	int cantidadTotal = calcularTotal();
        int cuenta = 0;
        int cantidadPreguntas = 50;
        Pregunta preguntas[] = new Pregunta[cantidadPreguntas];
        int escogidas[] = new int[preguntas.length];
        Arrays.fill(escogidas, -1);

        while (cuenta < preguntas.length) {
            int escogida = 0;
            try {
                File fichero = new File("preguntasISO2.txt");
                Scanner lectura = new Scanner(fichero, StandardCharsets.UTF_8.name());
                while (lectura.hasNext()) {
                    Random random = new Random();
                    int rng = random.nextInt(cantidadTotal);
                    String cuestion = lectura.nextLine();
                    cuestion_err=cuestion;
                    String pregunta1 = lectura.nextLine();
                    String pregunta2 = lectura.nextLine();
                    String pregunta3 = lectura.nextLine();
                    String pregunta4 = lectura.nextLine();
                    String solucion = lectura.nextLine();
                    int add = 1;
                    for (int i = 0; i < escogidas.length; i++) {
                        if (escogida == escogidas[i]) {
                            add = 0;
                        }
                    }
                    if (add == 1 && rng == 0 && cuenta < preguntas.length) {
                    	cuestion=cuestion.replace("\\n","\n");
                    	cuestion=cuestion.replace("\\t","\t");
                    	cuestion = cuestion.replace("<", "&lt;");
                    	cuestion = cuestion.replace(">", "&gt;");
                        Pregunta test = new Pregunta(cuestion, pregunta1, pregunta2, pregunta3, pregunta4, solucion);
                        preguntas[cuenta] = test;
                        escogidas[cuenta] = escogida;
                        cuenta++;
                    }
                    escogida++;
                    if (lectura.hasNextLine()) {
                        lectura.nextLine();
                    }
                }
                lectura.close();
            } 
            catch (FileNotFoundException e) {
                System.out.println("Error en la lectura del fichero, finalizando programa.");
                System.exit(0);
			}
            catch (NoSuchElementException e2) {
            	System.out.println("cuestion:"+cuestion_err);
            	System.exit(0);
            }
			escogida=escogida+1;
		}
		
		// Convertir el array a una lista
        ArrayList<Pregunta> listaPreguntas = new ArrayList<>(Arrays.asList(preguntas));

        // Reorganizar aleatoriamente la lista
        Collections.shuffle(listaPreguntas);
        for(int i=0;i<listaPreguntas.size();i++) {
        	preguntas[i]=listaPreguntas.get(i);
        }
		return preguntas;
	}
    
    public static int calcularTotal() {
    	int total = 0;
    	try {
            File fichero = new File("preguntasISO2.txt");
            Scanner lectura = new Scanner(fichero, StandardCharsets.UTF_8.name());
            while (lectura.hasNext()) {
            	lectura.nextLine();
            	total++;
            }
            lectura.close();
    	}
    	catch(FileNotFoundException e) {
            System.out.println("Error en la lectura del fichero, finalizando programa.");
		}
    	total=total/7;
    	//System.out.println(total);
    	return total;
    }
  
}
