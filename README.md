# Simulador de Algoritmos de Substituição de Páginas

## Resumo
Este projeto é um simulador de algoritmos de substituição de páginas em sistemas de gerenciamento de memória virtual. Ele permite comparar o desempenho de diferentes algoritmos, como FIFO (First In, First Out) e Clock (Relógio), medindo as faltas de página durante a execução de uma sequência de referências de páginas.

## Introdução
O gerenciamento eficiente da memória virtual é crucial para o desempenho dos sistemas operacionais. A substituição de páginas é uma tarefa essencial e complexa, diretamente relacionada à otimização da memória. Este simulador foi desenvolvido para comparar a eficiência de diversos algoritmos de substituição de páginas, entre eles:

1. **FIFO (First In, First Out)**: Substitui a página mais antiga na memória.
2. **Clock (Relógio)**: Oferece uma "segunda chance" às páginas antes de substituí-las, baseado no uso recente.

## Objetivos
- Simular e comparar diferentes algoritmos de substituição de páginas.
- Exibir o número de faltas de página para cada algoritmo, de acordo com uma sequência de páginas fornecida.

## Requisitos do Simulador

1. O programa deve receber uma sequência de páginas (números inteiros).
2. Implementar pelo menos quatro métodos para diferentes algoritmos de substituição de páginas.
3. A saída do programa deve indicar quantas faltas de página ocorreram para cada método, como no exemplo:
   - Método 1 - X faltas de página
   - Método 2 - X faltas de página
   - Método 3 - X faltas de página
   - Método 4 - X faltas de página
4. **Opção EXTRA (+1 ponto)**: Implementar uma interface gráfica e gráficos comparativos.

## Metodologia
O simulador será desenvolvido em Java. Ele receberá como entrada uma sequência de números inteiros representando as páginas a serem utilizadas. Em seguida, serão implementados quatro métodos correspondentes aos algoritmos de substituição. O programa calculará e apresentará o número de faltas de página para cada método.

## Resultados Esperados
Espera-se que o simulador forneça insights sobre o desempenho relativo dos diferentes algoritmos de substituição de páginas. Com base nos resultados obtidos, poderemos avaliar quais algoritmos são mais adequados para diferentes cenários e cargas de trabalho.

## Entrega
A entrega no AVA deve ser um relatório em PDF, conforme o modelo anexo, contendo as informações sobre a realização do trabalho e gráficos resultantes do comparativo. O código deve ser adicionado aos anexos com um **LINK** para o GITHUB do projeto. (Não esqueçam de incluir no arquivo README como funciona a execução, pois isso facilitará na correção do trabalho).

## Dicas
- Para a interface gráfica, utilize:
  - **Swing** para Java: [Introdução à Interface GUI no Java](https://www.devmedia.com.br/introducao-a-interface-gui-no-java/25646)
  - **Primefaces** para implementação com JSF (web): [Documentação Primefaces](https://www.primefaces.org/)
