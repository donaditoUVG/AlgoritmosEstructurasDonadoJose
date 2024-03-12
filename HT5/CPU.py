#Programa que simula a una CPU
#

import simpy
import random
import numpy as np
import matplotlib.pyplot as mat

RANDOM_SEED = 42

# Parámetros para configurar la simulación
INTERVALOS = [10, 5, 1] ##aumenta la carga
MEMORIA_TOTAL = 100 #RAM disponible
CAPACIDAD_CPU = 1 #CPU's disponibles 
VELOCIDAD_CPU = 3  # Instrucciones por cierta unidad de tiempo
INSTRUCCIONES_MAX = 10 #max de instrucciones 
TIEMPO_MAXIMO = 100
NUM_PROCESOS = [25, 50, 100, 150, 200]

tiempos_promedio = []
desviaciones_std = []
# Recursos y Procedimientos

##Programa Principal
class SistemaOperativo:
    def __init__(self, env, num_procesos, intervalo):
        self.env = env
        self.procesador = simpy.Resource(env, capacity=1)
        self.ram = simpy.Container(env, init=MEMORIA_TOTAL, capacity=MEMORIA_TOTAL)
        self.intervalo = intervalo
        self.num_procesos = num_procesos
        self.tiempos_ejecucion = []

    def llegada_proceso(self):
        for i in range(self.num_procesos):
            proce = Proceso(i, self.env, self.procesador, self.ram, self.tiempos_ejecucion)
            self.env.process(proce.proceso())
            yield self.env.timeout(random.expovariate(1.0 / self.intervalo))

class Proceso:
    
    def __init__(self, id, env, procesador, ram, tiempos_ejecucion):
        self.id = id
        self.env = env
        self.procesador = procesador
        self.ram = ram
        self.tiempos_ejecucion = tiempos_ejecucion
        self.memoria_necesaria = random.randint(1, 10)
        self.instruccionesTotal = random.randint(1, 10)
        self.instruccionesFaltantes = self.instruccionesTotal

    def proceso(self):
                memoria_obtenida = yield self.ram.get(self.memoria_necesaria)
                inicio_proceso = self.env.now

                while self.instruccionesFaltantes >0:
                    with self.procesador.request() as requerido:
                        yield requerido
                        instruccionesHechas = min(VELOCIDAD_CPU, self.instruccionesFaltantes)
                        yield self.env.timeout(1)
                        self.instruccionesFaltantes -= instruccionesHechas

                        if self.instruccionesFaltantes <= 0:
                            tiempo_total = self.env.now - inicio_proceso
                            self.tiempos_ejecucion.append(tiempo_total)
                            self.ram.put(self.memoria_necesaria)
                            break

    def simular(self, num_procesos, intervalo):
        random.seed(RANDOM_SEED)
        env = simpy.Environment()
        sistema = SistemaOperativo(env, num_procesos, intervalo)
        env.process(sistema.llegada_proceso())
        env.run()

        ##Calculo del tiempo promedio y desviacion estandar de los tiempos de ejecucion
        tiempo_promedio = np.mean(sistema.tiempos_ejecucion)
        desviacion_std = np.std(sistema.tiempos_ejecucion)
        return tiempo_promedio, desviacion_std

resultados = []

for num_proceso in NUM_PROCESOS:
    for intervalo in INTERVALOS:
        p = Proceso(0, None, None, None, None)
        tiempo_promedio, desviacion_std = p.simular(num_proceso, intervalo)
        resultados.append((num_proceso, intervalo, tiempo_promedio, desviacion_std))

for resultado in resultados:
    print(f"Número de procesos: {resultado[0]}, Intervalo: {resultado[1]}, Tiempo promedio: {resultado[2]}, Desviación estándar: {resultado[3]}")

# Gráfico
for intervalo in INTERVALOS:
    tiempos_promedio_intervalo = [resultado[2] for resultado in resultados if resultado[1] == intervalo]
    mat.plot(NUM_PROCESOS, tiempos_promedio_intervalo, label=f'Intervalo {intervalo}')

mat.xlabel('Número de procesos')
mat.ylabel('Tiempo promedio')
mat.legend()
mat.show()