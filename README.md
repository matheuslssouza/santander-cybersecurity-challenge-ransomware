# 🔐 Encrypt & Decrypt Program (Java)

Este é um programa Java simples de linha de comando para **criptografar e descriptografar arquivos**. Ele simula um comportamento semelhante ao de um ransomware (somente para fins educacionais!).

> ⚠️ **Aviso:** Use com cuidado. Este programa modifica arquivos e pode torná-los inacessíveis se a chave não for armazenada corretamente. Portanto, anote a chave gerada no terminal!

---

## 📦 Estrutura do Projeto

src/
├── Main.java
├── FileEncrypter.java
└── FileDecrypter.java

---

## ▶️ Como Executar

1. Compile os arquivos Java:

```bash
javac Main.java FileEncrypter.java FileDecrypter.java
Execute o programa:
```

```bash
java Main
```
🧠 Como Funciona
Ao executar, o programa exibe o seguinte menu:


Encrypt and Decrypt program, be careful!
Press 1 for encrypt, 2 for decrypt and 3 for exit:
1: Entra no modo de criptografia. Você informa o caminho do arquivo que deseja criptografar.

2: Entra no modo de descriptografia. Você informa o caminho do arquivo criptografado e a chave secreta.

3: Encerra o programa.

🛠️ Requisitos
Java 8 ou superior

Terminal ou IDE compatível com Java (como Eclipse, IntelliJ ou VSCode com plugin Java)

🔒 Observações sobre Segurança
A chave usada na criptografia deve ser guardada com segurança. Sem ela, os arquivos criptografados não poderão ser recuperados.

O algoritmo de criptografia usado nas classes FileEncrypter e FileDecrypter deve seguir boas práticas (ex: AES, chave de 128 ou 256 bits). Certifique-se disso ao implementar.

📂 Exemplo de Caminho de Arquivo
C:/Users/Documentos/Ransomware/teste.txt
Após a criptografia, será criado um arquivo com extensão .enc, como:


📚 Licença
Projeto com fins educacionais. Use com responsabilidade. Nenhuma responsabilidade é assumida por perdas de dados causadas pelo uso indevido.


