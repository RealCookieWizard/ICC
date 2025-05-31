Descarga todos los archivos manteniendo la estructura

Pon los archivos en una carpeta llamada EjecutarJava y dentro de esta carpeta crea una carpeta llamada FiguraGeometrica y mete todos los archivos ejecuta cmd desde EjecutarJava

Luego ejecuta:

javac FiguraGeometrica\*.java

java FiguraGeometrica.Main

Se decidió implementar el método toString() como **método abstracto** en la clase FiguraGeometrica.


El método toString() debe devolver una representación en texto de cada figura, pero esa representación es diferente según el tipo de figura. Por ejemplo:

- Un triángulo necesita mostrar su base, altura y su fórmula de perímetro.
- Un cuadrado solo necesita un lado.
- Un rectángulo necesita base y altura.

Si el método toString() se definiera en la superclase, sería demasiado genérico y no tendría sentido para todas las figuras. Además, obligar a que cada subclase implemente su propio toString() garantiza que la salida textual sea clara, útil y específica para cada figura.
