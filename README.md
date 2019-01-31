<h1>File Integration System</h1>

```
Video explicando o funcionamento do sistema: http://bit.ly/neogridfile
```

<h2>Stack Utilizada</h2>
<ol>
<li>Java 11</li>
<li>Spring Boot</li>
<li>Apache Camel</li>
<li>Hibernate</li>
<li>JPA</li>
<li>Google Commons</li>
</ol>

<b>Endpoint para solicitar relatorio Saida.txt: 

https://file-read-neogrid.herokuapp.com/file/dados/consolidados</b>

```
curl -X GET \
  https://file-read-neogrid.herokuapp.com/file/dados/consolidados \
```
<h2>Arquitetura de Fluxo dos Processos</h2>
<img src="https://i.imgur.com/EYBAWKq.jpg">