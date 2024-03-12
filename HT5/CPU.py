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

    class Proceso(self):
        def _init_(self, id, env, procesador, ram, tiempos)

        # Solicitar memoria
        with RAM.get(memoria) as request:
            yield request

            # Tiempo en espera por memoria
            tiempo_espera_memoria = env.now - tiempo_llegada

            # Estado "Ready"
            yield cpu.request()

            # Tiempo en espera por CPU
            tiempo_espera_cpu = env.now - tiempo_llegada - tiempo_espera_memoria

            # Ejecución en CPU
            for _ in range(INSTRUCCIONES_MAX):
                yield env.timeout(1 / VELOCIDAD_CPU)

            # Fin de la ejecución
            tiempo_ejecucion = env.now - tiempo_llegada

            # Liberar memoria
            RAM.put(memoria)

            # Generar siguiente proceso
            if intervalo != 10:
                env.process(proceso(env, f"{nombre}_{random.randint(1, 100)}"))

            # Estadísticas
            promedios[intervalo].append(tiempo_ejecucion)

    # Ejecutar la simulación
    for i in range(num_procesos):
        env.process(proceso(env, f"Proceso_{i + 1}"))

    env.run()

    # Imprimir resultados
    for intervalo in INTERVALOS:
        if len(promedios[intervalo]) > 0:
            promedio = sum(promedios[intervalo]) / len(promedios[intervalo])
            desviacion = np.std(promedios[intervalo])
        else:
            promedio = "N/A"
            desviacion = "N/A"

        print(f"Número de Procesos: {num_procesos}")
        print(f"Tiempo Promedio: {promedio}")
        print(f"Desviación estándar: {desviacion}")



if __name__ == "__main__":
    num_procesos_lista = [25, 50, 100, 150, 200]
    for num_procesos in num_procesos_lista:
        print(f"---- Simulación con {num_procesos} procesos ----")
        main(num_procesos)
