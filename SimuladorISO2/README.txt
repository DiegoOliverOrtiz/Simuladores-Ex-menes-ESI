Creador del simulador: Diego Oliver Ortiz

Sobre los test:
Simulador de examen de Ingeniería de Software 2 igual que en el fusilamiento, 50 preguntas de 4 opciones puedes avanzar y retroceder a voluntad (en el examen no se podrá ya que las preguntas van de 10 en 10), existe un atajo para poder navegar entre preguntas usando las flechas del teclado. Las preguntas incorrectas restan 0,33 (3 preguntas incorrectas equivalen a una buena), el valor que resta es el mismo que el de los test del campus y en el examen final, el simulador cuenta con 1150 preguntas.

Requisitos: 
Fichero con las preguntas llamado preguntasgISO2.txt con ese nombre EXACTO que contenga todas las preguntas.

Para ejecutar el simulador:
Haz doble clic en el archivo SimuladorISO2.jar o desde la consola, pero se puede perfectamente sin la consola y en mi opinión es más cómodo hacerlo con doble clic como si fuera un .exe, es necesario tener un interprete de java, preferiblemente una versión de java moderna.

Para añadir preguntas:
Mantén el formato de las preguntas entregables, es decir:
Primera línea: pregunta
Segunda línea: opción A, siendo el primer carácter sí o sí 'A' en mayúsculas.
Tercera línea: opción B, siendo el primer carácter sí o sí 'B' en mayúsculas.
Cuarta línea: opción C, siendo el primer carácter sí o sí 'C' en mayúsculas.
Quinta línea: opción D, siendo el primer carácter sí o sí 'D' en mayúsculas.
Sexta línea: respuesta con el formato : ANSWER: X donde X es la letra de la opción correcta MUY IMPORTANTE que sea el último carácter (no pongas puntos ni espacios después) y que esté en mayúsculas.
Séptima línea: línea en blanco (salto de línea) por favor que solo sea una.
A partir de aquí se repite el ciclo.

Comprueba que el documento es válido pasándoselo a chatgpt o Gemini o cualquier LLM con el siguiente prompt:
"Tengo el siguiente documento que contiene una ristra de preguntas para un simulador de examen, lo malo del simulador es que es MUY sensible y necesita que el documento respete religiosamente el formato de las preguntas, entonces tu tarea es comprobar que el documento respeta el formato de las preguntas el cual es el siguiente:
Primera línea: Pregunta (aquí no hay nada que comprobar)
Segunda línea: Opción A, el primer carácter de esta línea debe ser 'A'
Tercera línea: Opción B, el primer carácter de esta línea debe ser 'B'
Cuarta línea: Opción C, el primer carácter de esta línea debe ser 'C'
Quinta línea: Opción D, el primer carácter de esta línea debe ser 'D'
Sexta línea debe ser la respuesta, lo importante es el último carácter que debe ser 'A', 'B', 'C' o 'D'
Séptima línea: línea en blanco (salto de línea)
A partir de ahí se repite el patrón te cito aquí algunos de los errores más comunes que puede haber en el formato para que te sirva de guía: que haya más de un salto de línea tras la línea 7, que la línea 7 acabe con un carácter que no pertenece a los caracteres válidos (como un punto) que el primer carácter de las líneas dos a cinco (ambas incluidas) empiecen por un carácter que no es válido (como un guion, un espacio o un punto), que la pregunta ocupe más de una línea o que las opciones no estén separadas entre líneas y se junten a la pregunta. Pueden existir más errores a parte de estos, para solventarlos dime en que línea está el error y el texto de dicha línea."

No soy muy buen programador así que el simulador es muy sensible al formato de las preguntas, así que por favor asegúrate que esté bien si añades preguntas. En caso de detectar cualquier otro fallo solicita un pull request con las instrucciones generales adjuntadas en el directorio raíz del repositorio.


Créditos de las preguntas a los grupos de ISO2 del curso 2025/2026:
3B1:
Víctor Cerrillo Arévalo
Chorouk Chemnari
Adrian Díaz-Plaza Remesal
Imane El Harradji Aoury
Sergey Ghukasyan Poghosyan
Arturo González Rojas

3B5:
Oussama Abbassa Ueld Lub Baih
Denís Alberca García
Fernando de Haro Fernández
Javier Fernández Alcázar
Daniel Gallego Mora
óscar García Herrera
Arturo Jiménez Vargas

3BC1:
Iván Moreno Ballesteros
Pablo Paniagua Díaz
Alonso Rincón López
Daniela Ducy Salvatierra Vera
Pablo Sánchez Iglesias
Claudia Serrano Fernández

3BC2:
Jesús Márquez Duque
Manuel Porrero Sierra
David Ruiz Sánchez
Carlos Salgado Rojas
Ainhoa Sánchez Esteban
Ismael Serrano Usero

3BC4:
Pablo Mateos Aparicio Rodríguez
Ángel Prado Aranda
Sergio Rojo Nielfa
Miguel Ángel Triguero Elipe

3BC7:
Miguel Cruz Ureña
Jose Díaz Malaguilla Serrano de la Cruz
Adrián González Ruiz
Raul Grey Corredor
Asier Lizcano Castaño
Diego Oliver Ortiz

3C4:
Alberto Lillo García
Carlos Llamas Megía
Iván Jesús Mora García
Miguel Mora Vega
Alba Romero de los Ríos
Jorge Sánchez Doctor
Pedro Vellón López

3C8:
Eduardo Gallego Fernandez
Vicente García de Mateos López
Jorge Giménez Aranda
Francisco Macías Jiménez
Gonzalo Moreno Gutiérrez
Mario Muñoz Galera

Ayuda a expandir o corregir las preguntas solicitando una pull request con las instrucciones generales adjuntadas en el directorio raíz del repositorio.