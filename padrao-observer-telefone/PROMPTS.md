# Uso de IA nesta questão

## Prompt utilizado

Ferramenta: Claude (Anthropic). Anexos: `Lista Avaliativa I.pdf` (enunciado) e `src.zip` (código inicial).

> Contexto: projeto Java com o pacote `telephone` em anexo (`PhoneModel`, `KeyPad`, `Screen`, `Main`).
> O `KeyPad` envia dígitos para o `PhoneModel`, que apenas os armazena; a `Screen` está vazia.
>
> Objetivo: aplicar o padrão Observer para que a interface com o usuário seja avisada a cada novo dígito
> inserido, com dois observadores criados pela `Screen`: um que imprime o dígito mais recente e outro que,
> ao completar o número, imprime "Agora discando 081999887766...". Restrições do enunciado: somente a UI
> pode imprimir na tela, e o modelo do telefone não pode ter nenhuma dependência da UI.
>
> Não me dê a solução pronta. Me dê um passo a passo (tutorial) incremental para eu implementar, seguindo
> estas condições:
> 1. cada etapa deve deixar o projeto compilando, para virar um commit isolado;
> 2. em cada etapa, diga quais arquivos mudam e qual é o papel de cada classe no padrão (sujeito,
>    interface de observador, observadores concretos);
> 3. explique onde a notificação deve ser disparada e como as duas restrições acima ficam garantidas
>    olhando só para o código do modelo;
> 4. aponte, na etapa de verificação, o que comparar entre a saída obtida e o exemplo do enunciado.

## Passo a passo (tutorial) sugerido pela IA para esta questão

| Passo | O que fazer | Commit correspondente |
|---|---|---|
| 1 | Criar a interface `PhoneObserver` com `onDigitAdded(int digit)`. | `Passo 1` |
| 2 | No `PhoneModel`, manter uma lista de observadores, oferecer `addObserver(...)` e notificar todos dentro de `addDigit`. | `Passo 2` |
| 3 | Na `Screen`, registrar dois observadores: um imprime o último dígito; outro, quando o número completa 12 dígitos, imprime "Agora discando <número>...". | `Passo 3` |
| 4 | Compilar, rodar e comparar com a saída do enunciado. | `Ajuste` (commits seguintes) |

## Ajustes feitos sobre o que a IA sugeriu
Cada ajuste tem um commit próprio começando com **"Ajuste:"**, explicando por que a sugestão não
servia totalmente e por que o ajuste melhora a solução. Resumo:

1. **Dígitos inválidos e texto em inglês no KeyPad** — `MAX_DIGIT = 12` sorteava 10 e 11, que não são dígitos
   de telefone; e a saída esperada é "Pressionando: X", não "Pressing: X".
2. **Número fixo para reproduzir a saída do enunciado** — com dígitos aleatórios nunca sairia
   `081999887766`. Foi criado `KeyPad.dial(String)`; a simulação aleatória continua existindo.
3. **Encapsulamento da lista de dígitos** — `getDigits()` devolvia a lista interna; qualquer observador
   poderia alterá-la. Passou a devolver uma visão somente-leitura.
