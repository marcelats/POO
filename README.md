# Deckquest

Um jogo simples, single-player, offline, e em turnos para te entreter um pouco nessa pandemia.

## Sumário

- [Como jogar](#como-jogar)
- [Classes](#classes)
  - [Guerreires](#guerreires)
  - [Arqueires](#arqueires)
  - [Bruxes](#bruxes)
  - [Sacerdotes](#sacerdotes)
- [Atributos](#atributos)
  - [HP](#saúde-hp)
  - [ATK](#ataque-atk)
  - [FE](#fé-fe)
  - [DEF](#defesa-def)
  - [CON](#constituição-con)
  - [AGI](#agilidade-agi)
  - [XP](#experiência-xp)
  - [LV](#level-lv)
- [Ações](#ações)
  - [Ataque](#ataque)
  - [Cura](#cura)
- [Glossário](#glossário)
  - [Batalha](#batalha)
  - [Combate](#combate)
- [Sobre o projeto](#sobre-o-projeto)
  
## Como jogar

Antes de começar, saiba que o número de batalhas e a quantidade de personagens no deck são gerados aleatoriamente, só para deixar as coisas menos repetitivas :wink:

**1.** Veja quantos personagens lutarão por ti nesse combate e escolha quantos terão em cada [classe](https://github.com/marcelats/POO#classes).
> Em um combate de 10 personagens, você pode ter 4 guerreires + 2 arqueires + 2 bruxes + 2 sacerdotes, ou 5 guerreires + 5 sacerdotes, ou até mesmo 10 bruxes! Mas tenha sempre em mente as forças e fraquezas de cada um.

**2.** Escolha um personagem para colocar em batalha, seu oponente escolherá um também.

**3.** Caso o seu personagem tenha mais _agilidade_ escolha qual ação ele realizará, senão, espere seu oponente fazer uma ação e depois pode agir. Em caso de empate, o primeiro atacante é decidido aleatoriamente.
> Se um personagem for morto, mesmo que tenha feito ação ou não, a batalha se encerra e quem foi derrotado entrega seus pontos de experiência para o adversário.

**4.** Repita o passo 2 e 3 até que o número de batalhas acabe ou todos os personagens de um jogador morram.

Bem fácil, né? :smile:

## Classes

Existem 4 classes no jogo:

#### Guerreires 
Equilibrados em ataque e defesa, são sua confiável linha de frente em qualquer momento.
HP|Atk|Def|Agi|Con
:-:|:-:|:-:|:-:|:-:
100|50|20|10|10

#### Arqueires 
Atacam rápido e dão um dano considerável, porém, são mais frágeis que os seus companheiros de espada e escudo.
HP|Atk|Def|Agi|Con
:-:|:-:|:-:|:-:|:-:
75|70|10|20|5

#### Bruxes 
A classe que mais demora atacar no jogo, mas quando conseguem conjurar sua magia é melhor sair da frente. Causam um dano absurdo, mas também morrem bem fácil.
HP|Atk|Def|Agi|Con
:-:|:-:|:-:|:-:|:-:
50|100|5|5|5

#### Sacerdotes 
Seu suporte nas horas difíceis, conseguem curar os aliados (e a si mesmos), mas não podem atacar.
HP|Fe|Def|Agi|Con
:-:|:-:|:-:|:-:|:-:
100|100|0|20|5


## Atributos

Cada personagem tem uma série de atributos que são usados em diversas funções do jogo:

#### Saúde (HP)
Representa a vida do personagem, que é morto caso esse valor chegue a zero. É recuperada a cada batalha fora de combate (por um valor igual à quantidade de _constituição_ do personagem) e também via magias de cura, mas nunca podendo exceder seu valor máximo.

#### Ataque (Atk)
Usado por _Guerreires_, _Arqueires_ e _Bruxes_ para calcular o dano causado.
> Dano = Ataque do personagem - Defesa do oponente.

#### Fé (Fe)
Usado por _Sacerdotes_ para calcular a cura realizada.

#### Defesa (Def)
Usado para diminuir o dano causado por ataques inimigos.

#### Constituição (Con)
Determina a quantidade de pontos de saúde recuperados a cada batalha que o personagem passa fora de combate.
> Ex.: Se um personagem tem 10 de _constituição_, ele recuperará 10 pontos de _saúde_.

#### Agilidade (Agi)
Determina quem começará a batalha atacando.

#### Experiência (XP)
Todos os personagens começam com 100 de XP. Se um personagem derrota outro, os pontos de _experiência_ do derrotado são acrescentados aos pontos do vitorioso. Quando esse valor é atinge a quantidade necessária (de acordo a tabela abaixo), há um aumento de _level_. 

Level | Quantidade de XP necessária
:---: | :-------------------------:
2 | 200
3 | 400
4 | 800
5 | 1600
...|...
> Ou seja, a quantidade de XP necessária dobra a cada aumento de level, e não há limite de leveis.

#### Level (Lv)
Diz respeito à força de um personagem, quanto maior esse valor, mais forte e mais difícil de ser derrotado ele é. Quando alguém sobe de level, o valor seus atributos são aumentado, de acordo a seguinte tabela:

Atributo | Aumento
:------: | :-----:
XP Máxima | x2
Saúde Máxima | x1.2
Ataque / Fé | x1.15
Defesa | x1.15
Constituição | x1.75
Agilidade | x1.15

## Ações

Existem 2 categorias de ações no jogo, cada personagem podendo realizar uma ação no seu turno. São elas:

#### Ataque
Causa dano a um oponente escolhido, diminuindo sua _saúde_ de acordo sua _defesa_.

#### Cura
Magia somente usada por _Sacerdotes_ que recupera a _saúde_ do alvo por uma quantidade de pontos iguais ao seu valor de _fé_.


## Glossário

#### Batalha
É o ciclo que da ritmo ao jogo. No início de uma batalha cada jogador pega um personagem do deck e coloca em combate, aquele com maior valor de _agilidade_ atacará primeiro e depois é a vez do oponente. Ao final da batalha os personagens com _saúde_ voltam para o deck enquanto os mortos (caso hajam) entregam seus pontos de _experência_ ao adversário. Caso um personagem morra antes da sua vez ele é impossibilitado de realizar ações, ou seja, a batalha acaba quando alguém morre.

#### Combate
É um número determinado de batalhas. Acaba quando um jogador fica sem personagens no deck ou quando chegar ao número máximo de batalhas definido no início do jogo. Se o combate acabar porque o número máximo de batalhas foi alcançado, cada jogador soma os pontos de _experiência_ dos seus personagens, consagrando ganhador do jogo aquele com maior quantidade.


## Sobre o projeto
Deckquest foi criado por um pequeno grupo de alunos da USP - São Carlos para reforçar conceitos de Programação Orientada a Objetos, por isso o código é completamente encapsulado e escrito em JAVA.
