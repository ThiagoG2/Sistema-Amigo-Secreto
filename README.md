# Sistema desenvolvido em Java(utilizando Javafx e padrões de projeto mvc, singleton e facade) como exercício da disciplina de Introdução à programação 2 - Java - UFRPE 💻 

  📌 Requisitos do Sistema:
 
- REQ1. O sistema deve permitir o cadastramento de pessoas com as seguintes informações: nome completo, apelido, senha e lista de presentes que deseja ganhar. Não deve ser permitido que duas pessoas tenham o mesmo apelido. Essa lista de presentes poderá ser adicionada em outro momento que não seja a criação da pessoa.✔️

- REQ2. O sistema deve permitir a criação de grupos com as seguintes informações: nome do grupo (único), data do sorteio, lista de participantes e lista de amigos secretos. A lista de participantes não é adicionada no momento da criação do grupo, mas numa tela separada para manutenção das informações do grupo. A lista de amigos secretos somente é preenchida após sorteio. Não pode haver dois grupos com o mesmo nome.✔️

- REQ3. O sistema deve permitir a adição de pessoas em um grupo, desde que a pessoa e o grupo já estejam previamente cadastrados.✔️

- REQ4. O sistema deve permitir o cadastramento de presentes com as seguintes informações: categoria, descrição e preço.✔️

- REQ5. O sistema deve permitir a escolha dos presentes de cada pessoa a partir da lista de presentes já cadastrada anteriormente.✔️

- REQ6. O sistema deve realizar o sorteio dos amigos secretos e verificar se a data de hoje é igual ou maior que a data escolhida no momento da criação do grupo. O sorteio consiste em fazer com que todos do grupo recebam um amigo secreto e tenham sido escolhidos para ser o amigo secreto de alguém. A escolha dos amigos secretos deve garantir que não haja subgrupos de amigos isolados. Exemplo, num grupo com 6 pessoas (A, B, C, D, E, F), o sorteio NÃO pode permitir a seguinte relação: A -> B -> C -> A e D -> E -> F -> D. Uma vez realizado o sorteio, o mesmo não pode ser mais realizado.✔️

- REQ7. O sistema NÃO precisa ter controle de acesso para usuários diferentes, mas, uma vez executando o sistema, a tela com informações sobre qual amigo secreto cada pessoa tirou deve ser controlado pela senha pessoal.✔️

- REQ8. Para fins de teste, você deve fornecer em algum de seus controladores um método que retorne a lista de pessoas de um grupo com seus respectivos amigos secretos, com a intenção se verificar em modo de depuração se o sorteio foi realizado corretamente.✔️

- REQ9. O sistema deve obedecer ao padrão arquitetural MVC, ou seja, deve ser estruturado em camadas.✔️
