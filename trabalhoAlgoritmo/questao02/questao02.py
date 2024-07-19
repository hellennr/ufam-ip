nivel = int(input("digite o nível do professor: "))
horaTrabalhada = float(input("digite as horas trabalhadas: "))

salario = 0

if(nivel==1):
    salario = 12.00 * horaTrabalhada
else:
    if(nivel==2):
        salario = 17.00 * horaTrabalhada
    else:
        salario = 25.00 * horaTrabalhada

print("salario: ", salario)
