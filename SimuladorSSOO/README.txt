Creador del simulador: Diego Oliver Ortiz

Sobre los test:
Simulador de examen de Sistemas Operativos 1 con test de 50 preguntas, con preguntas de examen, preguntas del campus y preguntas propias generadas en base a la teoría, se puede avanzar y retroceder en las preguntas a voluntad, existe un atajo para poder navegar entre preguntas usando las flechas del teclado. La nota se calcula usando la fórmula de cálculo de nota del propio examen, el simulador cuenta con un total de 655 preguntas. Hay algunas preguntas que son tablas como la del examen se representan en texto, por ejemplo: Trabajo{1, 2, 3}, T. de Llegada{0, 1, 2}, Rf. 1 de CPU{3, 1, 1}, Rf. de E/S{3, 3, 2}, Rf. 2 de 
CPU{1, 1, 3} sería una tabla donde Trabajo es el nombre de una columna y los valores en corchete son los valores de la columna trabajo ordenados según su fila correspondiente.

Requisitos:
Fichero de preguntas llamado preguntasSSOO.txt con ese nombre EXACTO que contenga todas las preguntas.

Para ejecutar el simulador:
Haz doble clic en el archivo SimuladorSSOO.jar o desde la consola, pero se puede perfectamente sin la consola y en mi opinión es más cómodo hacerlo con doble clic como si fuera un .exe, es necesario tener un interprete de java, preferiblemente una versión de java moderna.

Para añadir preguntas:
Mantén el formato del trabajo teórico, es decir:
Línea 1: Pregunta 
Línea 2: Respuesta correcta 
Línea 3-5: Respuestas incorrectas (si es una pregunta con 4 opciones la línea 5 deberá tener un guion: “-”) 
Línea 6: Línea en blanco (una sola)
A partir de aquí se repite el ciclo

Comprueba que el documento es válido pasándoselo a chatgpt o Gemini o cualquier LLM con el siguiente prompt:
"Tengo el siguiente documento que contiene una ristra de preguntas para un simulador de examen, lo malo del simulador es que es MUY sensible y necesita que el documento respete religiosamente el formato de las preguntas, entonces tu tarea es comprobar que el documento respeta el formato de las preguntas el cual es el siguiente:
Primera línea: Pregunta (aquí no hay nada que comprobar)
Segunda línea: Respuesta correcta
Tercera a quinta línea: resto de respuestas (respuestas incorrectas)
Sexta línea: línea en blanco (salto de línea)
A partir de ahí se repite el patrón te cito aquí algunos de los errores más comunes que puede haber en el formato para que te sirva de guía: que haya más de un salto de línea tras la línea 6, que la línea 5 no contenga respuesta oque una pregunta ocupe más de una línea."

No soy muy buen programador así que el simulador es muy sensible al formato de las preguntas, así que por favor asegúrate que esté bien si añades preguntas. En caso de detectar cualquier otro fallo solicita un pull request con las instrucciones generales adjuntadas en el directorio raíz del repositorio.

Créditos de las preguntas a:
Diego Oliver Ortiz
Ayuda a expandir o corregir las preguntas solicitando una pull request con las instrucciones generales adjuntadas en el directorio raíz del repositorio.
