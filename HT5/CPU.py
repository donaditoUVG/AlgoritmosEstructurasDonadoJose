import simpy
RANDOM_SEED = 42

# Parámetros para configurar la simulación
INTERVALOS = [10, 5, 1] ##aumenta la carga
MEMORIA_TOTAL = 100 #RAM disponible
CAPACIDAD_CPU = 1 #CPU's disponibles 
VELOCIDAD_CPU = 3  # Instrucciones por cierta unidad de tiempo
INSTRUCCIONES_MAX = 10 #max de instrucciones 

# RECURSOS DE LA MÁQUINA
RAM = simpy.Container(env, init=MEMORIA_TOTAL, capacity=MEMORIA_TOTAL) #Simulacion de la RAM
cpu = simpy.Resource(env, capacity=CAPACIDAD_CPU)


