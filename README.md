# Simulador de Algoritmos de Substituição de Páginas
## Resumo
Este trabalho propõe o desenvolvimento de um simulador para avaliar o desempenho de diferentes algoritmos de substituição de páginas em sistemas de gerenciamento de memória virtual. Os algoritmos estudados incluem FIFO, LRU, do Relógio, Ótimo, NFU e de Envelhecimento.
## Introdução
O gerenciamento eficiente da memória virtual é crucial para o desempenho dos sistemas operacionais. A alocação e substituição de páginas são tarefas complexas que afetam diretamente a experiência do usuário. Neste contexto, os algoritmos de substituição de páginas desempenham um papel fundamental na otimização do uso da memória. Sabemos e vimos em sala os principais algoritmos de substituição de páginas:
1. **Algoritmo FIFO (First In, First Out)**:  
   Nesse algoritmo, a página mais antiga na memória é a primeira a ser substituída quando ocorre uma falta de página.  
   **Implementação**: Mantenha uma fila (ou lista) das páginas na ordem em que foram carregadas. Quando uma nova página precisa ser trazida para a memória, remova a página no início da fila. É simples de entender e implementar, mas pode não ser eficiente em cenários reais, pois não considera o padrão de acesso.
2. **Algoritmo LRU (Least Recently Used)**:  
   Esse algoritmo substitui a página que foi menos recentemente usada.  
   **Implementação**: Mantenha uma estrutura (como uma lista ligada) para rastrear a ordem de uso das páginas. Quando ocorre uma falta de página, remova a página que foi usada menos recentemente. É mais eficiente do que o FIFO, pois considera o histórico de uso, mas requer mais overhead para manter o registro de uso.
3. **Algoritmo do Relógio (Clock)**:  
   Também conhecido como “segunda chance”, esse algoritmo simula um relógio circular.  
   **Implementação**: Crie uma lista circular de páginas. Quando ocorre uma falta de página, verifique se a página apontada pelo ponteiro do relógio foi usada recentemente (geralmente com um bit de referência). Se sim, avance o ponteiro e redefine o bit; caso contrário, substitua essa página. É uma abordagem intermediária entre FIFO e LRU, oferecendo um equilíbrio entre complexidade e eficiência.
4. **Algoritmo Ótimo**:  
   Esse é o algoritmo ideal, mas não é prático na implementação real, pois requer conhecimento futuro.  
   **Implementação**: Substitui a página que será usada mais tarde no futuro (ótima previsão). Serve como referência para avaliar o desempenho dos outros algoritmos, pois fornece um limite inferior para a taxa de faltas de página.
5. **Algoritmo NFU (Not Frequently Used)**:  
   Baseado na frequência de uso das páginas.  
   **Implementação**: Atribui um contador a cada página e incrementa o contador sempre que a página é referenciada. A página com o menor contador é substituída. Embora simples, pode ser suscetível a fenômenos de "fome", onde páginas pouco usadas nunca são removidas.
6. **Algoritmo de Envelhecimento (Aging)**:  
   Uma variação do LRU em software, que considera a idade das referências.  
   **Implementação**: Usa bits de envelhecimento para rastrear o tempo desde a última referência a cada página. A cada intervalo de tempo, as referências de páginas são "deslocadas" para a direita, diminuindo o valor do bit de referência. As páginas com menor tempo de referência são substituídas, permitindo um balanceamento entre frequência e recência.
## Objetivos
Sabendo que temos essas implementações, vamos criar um SIMULADOR para os principais algoritmos de substituição de páginas, com o objetivo de verificar as faltas de páginas no gerenciamento da memória virtual.
### Atenção aos detalhes do simulador:
1. O programa deve iniciar com uma cadeia de números (int) que irá indicar nossa página a ser utilizada.
2. No programa devem haver 4 métodos (escolha entre os 6 listados anteriormente) onde serão implementados os 4 algoritmos de substituição.
3. A saída do programa (cada método) deve indicar como ficaram as faltas de página por cada método, ou seja como no exemplo abaixo:
   - Método 1 - X faltas de página
   - Método 2 - X faltas de página
   - Método 3 - X faltas de página
   - Método 4 - X faltas de página
4. Uma opção EXTRA (+1 ponto) ao trabalho seria usar uma interface gráfica para utilização do programa e uma indicação com os gráficos como comparativo.  
   Ver o site como referência: [SDPM Simulator](https://sdpm-simulator.netlify.app/simulator)  
   **DICA:** Usem:
   - Swing para o próprio JAVA - [Introdução à Interface GUI no Java](https://www.devmedia.com.br/introducao-a-interface-gui-no-java/25646)
   - Primefaces para implementação com JSF (web) - [Primefaces](https://www.primefaces.org/)
## Metodologia
O simulador será desenvolvido em linguagem de programação Java. Ele receberá como entrada uma sequência de números inteiros representando as páginas a serem utilizadas. Em seguida, serão implementados quatro métodos correspondentes aos algoritmos de substituição. O programa calculará e apresentará o número de faltas de página para cada método.
## Resultados Esperados
Espera-se que o simulador forneça insights sobre o desempenho relativo dos diferentes algoritmos de substituição de páginas. Com base nos resultados obtidos, poderemos avaliar quais algoritmos são mais adequados para diferentes cenários e cargas de trabalho. A entrega no AVA deve ser um relatório no formato PDF e feito de acordo com o modelo anexo, com as informações relativas à realização do trabalho com os gráficos resultantes do comparativo. O código deve ser adicionado aos anexos com um LINK para o GITHUB do projeto. (Não esqueçam de colocar no arquivo README como funciona a execução, isso irá facilitar na correção do trabalho).
