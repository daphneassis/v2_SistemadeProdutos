# v2_SistemadeProdutos
Sistema de Produtos POO2_2 versao
Controle de estoque de produtos com Administrador já setado com o login: "lol", senha:"123".
Menu Inicial onde é possível:
(a)fazer o login como Administrador para cadastrar, visualizar, editar e remover produtos.
(b)fazer o cadastro do Cliente de primeiro acesso e, em seguida, o login com os dados cadastrados. 
Caso eles estejam corretos, abre o Menu do Cliente com as opções:visualizar lista de produtos, filtrar por categoria, filtrar por marca, 
ordenar por nome (ordem crescente e descrescente), ordenar por preço(ordem crescente e decrescente) e por fim, retornar ao Menu Inicial, onde é possível
encerrar o Programa. 
Obs:Antes de fazer o cadastro e login como Cliente, deve-se cadastrar os produtos como Adm para o Cliente ter acesso à lista de produtos. 

O projeto foi estruturado da seguinte forma:
Há uma classe abstrata de Produtos (ProdutoAbstrato) que implementa a interface ProdutosAcoes com os métodos novaDoacao e fazerPromocao. As classes Informatica,
Mercado e Livro tem atributos próprios, herdam da classe ProdutoAbstrato, implementam interfaces de comportamentos próprios das suas áreas e também a de ProdutosAcoes
com suas particularidades.
As classes Administrador e Cliente herdam de Pessoa, com login e senha e as classes dentro do pacote ValidarUsuario servem para validar os logins e senhas de 
acesso cadastrados. Caso estejam validados, abre os Menus próprios para Adm e Cliente. 
Os Menus foram estruturados da seguinte forma: interfaces separadas com métodos próprios de Adm e Cliente, os MenusAbstratos como classes abstratas implementam as 
interfaces desenvolvendo esses métodos e por fim os Menus(MenuAdmClasseConcreta e MenuClienteClasseConcreta) herdam das classes abstratas, de modo que haja uma melhor
organização do código. 
Na opção de Cadastro de Produtos para o Adm (para além dos dados básicos de nome do produto, preço, marca e categoria), é necessário informar
nos produtos de Informática, o Software(String) e memória(Double); em Mercado, a data de validade (Date) e seção do marcado(como Enums, é possível identificar
se o objeto pertence à parte de higiene, frios, grãos, bebidas e hortifruti do mercado) e em Livro, é necessário informar a editora(String) e o sobrenome do Autor(String).
A opção "editar Produto" é feita pelo nome do produto podendo ser modificado: nome, preço, marca e categoria. A opção remover produto também é feita pelo nome.
