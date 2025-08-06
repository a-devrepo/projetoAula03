# Projeto: Cadastro de Funcionários (CRUD)

## Descrição

Este é um projeto simples de cadastro de funcionários implementado com **Java 17**, utilizando **JDBC** para acesso ao banco de dados **MySQL**.  
O banco de dados é executado dentro de um container **Docker**, e a aplicação segue uma arquitetura em camadas para garantir organização, coesão e separação de responsabilidades. As configurações de banco são carregadas a partir de um arquivo de propriedades externo.

---

## Tecnologias e Ferramentas

- Java 17  
- JDBC (Java Database Connectivity)  
- MySQL (em container Docker)  
- Docker / Docker Compose  
- IDE (IntelliJ, Eclipse ou similar)  

---

## Arquitetura de Camadas

O projeto está organizado para manter a **separação de responsabilidades**:

- **`principal`**: Ponto de entrada do programa, instanciando e injetando dependências.  
- **`controllers`**: Interpreta ações e delega para a camada de serviço.  
- **`services`**: Contém a lógica de negócio e orquestra a comunicação entre controller e repositório.  
- **`repositories`**: Acesso direto ao banco de dados com comandos SQL (CRUD).  
- **`factories`**: Fornece conexões com o banco MySQL (`ConnectionFactory`).  
- **`entities`**: Representa as entidades do domínio (ex.: `Funcionario`).  
- **`exceptions`**: Exceções customizadas para erros de persistência ou de negócio.  
- **`utils`**: Handler que centraliza tratamento e exibição de erros.

---

## Como executar o projeto

### 1. Clonar o repositório
```bash
git clone https://github.com/a-devrepo/projetoAula03.git
cd projetoAula03
```

---

### 2. Subir o banco de dados com Docker
Certifique-se de ter o **Docker** e **Docker Compose** instalados.  
Na raiz do projeto, execute:
```bash
docker compose up -d
```

Isso criará um container MySQL com as seguintes credenciais:  

| Parâmetro          | Valor                     |
|--------------------|---------------------------|
| Host               | `localhost`               |
| Porta              | `3306`                    |
| Usuário Root       | `root`                    |
| Senha Root         | `root`                    |
| Banco de Dados     | `funcionarios_db`          |
| Usuário da App     | `appuser`                  |
| Senha da App       | `apppassword`              |

---

### 3. Baixar e configurar o MySQL Connector/J

O **MySQL Connector/J** é o driver JDBC necessário para a aplicação se conectar ao MySQL.

Para que a aplicação funcione corretamente, precisamos ter o arquivo do driver dentro da pasta chamada `libs`, que deve estar localizada **na raiz do projeto**.

#### Como criar a pasta `libs` na raiz do projeto

1. **Abra o terminal ou prompt de comando** no seu computador.

2. **Entre na pasta do projeto**, que você clonou do GitHub. Por exemplo, se você clonou com o comando:  
   ```bash
   git clone https://github.com/a-devrepo/projetoAula03.git
   cd projetoAula03
   ```

3. **Verifique se a pasta `libs` existe:**  
   - No Linux ou Mac, rode:  
     ```bash
     ls -l
     ```  
     e veja se aparece a pasta `libs`.  
   - No Windows, rode:  
     ```cmd
     dir
     ```  
     e procure a pasta `libs`.

4. **Se a pasta `libs` não existir, crie-a com o comando:**  
   - No Linux ou Mac:  
     ```bash
     mkdir libs
     ```  
   - No Windows (Prompt de Comando):  
     ```cmd
     mkdir libs
     ```  
   - No Windows (PowerShell):  
     ```powershell
     New-Item -ItemType Directory -Name libs
     ```

5. Agora você tem uma pasta chamada `libs` dentro da raiz do projeto, pronta para receber o arquivo do driver.

---

#### Baixando o MySQL Connector/J

Se o arquivo do driver **não estiver presente** dentro da pasta `libs`, faça o download seguindo estes passos:

1. Acesse o site do Maven Central para o MySQL Connector/J:  
   [https://central.sonatype.com/artifact/com.mysql/mysql-connector-j](https://central.sonatype.com/artifact/com.mysql/mysql-connector-j)

2. Clique na versão mais recente (por exemplo, `8.4.0`) para abrir a página da versão.

3. Baixe o arquivo `.jar` (geralmente chamado algo como `mysql-connector-j-8.4.0.jar`).

4. Copie o arquivo `.jar` baixado para dentro da pasta `libs` que você acabou de criar.

---

#### Configurando o driver na IDE

Após colocar o arquivo `.jar` na pasta `libs`, configure sua IDE para reconhecer o driver:

- Clique com o botão direito no projeto → **Build Path** (ou equivalente) → **Add JARs...**  
- Navegue até a pasta `libs` dentro do seu projeto e selecione o arquivo `.jar`.

---

### 4. Executar o script SQL

O script `script.sql` está na raiz do projeto.  
Você pode executá-lo de duas formas:

**Via terminal (ainda na raiz do projeto):**
```bash
docker exec -i mysql-cadastro-funcionarios mysql -uappuser -papppassword funcionarios_db < script.sql
```

**Ou via cliente SQL** (MySQL Workbench, DBeaver, etc.):  
- Host: `localhost`  
- Porta: `3306`  
- Usuário: `appuser`  
- Senha: `apppassword`  
- Banco: `funcionarios_db`  

---

### 5. Configurar o arquivo de propriedaes

- Caminho: src/main/resources/database.properties  

- Conteúdo:
   - db.url=jdbc:mysql://localhost:3306/funcionarios_db
   - db.username=appuser
   - db.password=apppassword

---

### 6. Executar a aplicação na IDE

1. Abra o projeto na sua IDE (IntelliJ, Eclipse ou outra de sua preferência).  
2. Verifique se o **MySQL Connector/J** está adicionado ao classpath.  
3. Localize a classe `Main` no pacote `principal`.  
4. Execute a classe como **Java Application**.

---

## Observações
- As credenciais do banco estão no `docker-compose.yml` devem corresponder às configuradas no arquivo `database.properties`.  
- Caso altere qualquer dado no `docker-compose.yml` (usuário, senha, banco), atualize também no arquivo.  
- O projeto segue boas práticas de **arquitetura em camadas** para facilitar manutenção e evolução.