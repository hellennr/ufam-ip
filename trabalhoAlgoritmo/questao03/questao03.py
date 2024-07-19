def calcular_peso_ideal():
    sexo = input("Informe o sexo (m/f): ").lower()
    altura = float(input("Informe a altura em metros: "))

    if sexo == 'm':
        peso_ideal = (72.7 * altura) - 58
    elif sexo == 'f':
        peso_ideal = (62.1 * altura) - 44.7
    else:
        print("Sexo não reconhecido. Informe 'm' para masculino ou 'f' para feminino.")
        return

    print(f"O peso ideal é {peso_ideal:.2f} kg")
    
calcular_peso_ideal()
