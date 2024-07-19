print("Insira seu peso")
peso = float(input())

print("Insira sua altura")
altura = float(input())

imc = peso/(altura * altura)

if(imc < 18.5):
    print(imc + "Abaixo do peso")
else:
    if((imc >= 18.5 ) and (imc < 25)):
        print(imc + "peso normal")
    else:
        if((imc >= 25) and (imc < 30)):
            print(imc + "acima do peso")
        else:
            print(imc + "obesidade")
