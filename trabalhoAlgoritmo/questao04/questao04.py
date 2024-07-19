ano = int(input())
preco = float(input())


if(ano<1990):
    imposto = 0.01 * preco
else:
    if(ano>=1990):
        imposto = 0.015 * preco
    else:
        print("por favor digite um vALOR VALIDO")


print(imposto)