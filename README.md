# Trabalho final de Sistemas Distribuidos

Ao fazer alteração em qualquer arquivo, deve-se compilar novamente os arquivos .java:
```
javac Servidor.java
```

Os arquivos de servidor devem ser compilados com rmic para gerar os arquivos stub:
```
rmic ServidorFilmes
```

Isso vai gerar o arquivo: **ServidorFilmes_Stub.class**

## Iniciando a aplicação

Para iniciar a aplicação, primeiramente deve-se iniciar o rmiregistry:
```
rmiregistry &
```

Depois deve-se iniciar o servidor, por exemplo:
```
java IniciaServidor
```

Em outro terminal, inicie os arquivos clientes, por exemplo:
```
java InsereFilme
```
```
java ListaFilmes
```