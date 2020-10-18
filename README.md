# versao_1_0_0

Projeto Spring boot utilizando banco de dados h2,swagger e token jwt.

Porta padrão do projeto está configurada para 8070, caso queira acessar o swagger deve acessar a seguinte url : http://localhost:8070/swagger-ui.html

Para acessar o banco de dados totalmente configurado conforme solicitado, deve-se copiar o path do seguinte arquivo : db.mv.db que está localizado na pasta resources,
após isso acessar a seguinte url http://localhost:8070/h2 e colar o path copiado anteriormente no campo JDBC URL da seguinte maneira : jdbc:h2:file:{path} após 
isso é só clicar em "Connect"
