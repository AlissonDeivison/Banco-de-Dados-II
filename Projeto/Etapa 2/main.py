from multiprocessing import connection
import requests
import psycopg2
from psycopg2 import OperationalError

# Parâmetros

dbname = 'basquete'
user = 'alisson'
password = '12345'
host = 'localhost'

# Obtendo os dados

requisicao = requests.get("https://www.balldontlie.io/api/v1/teams")
dados = requisicao.json()['data']

# Abrir a conexão com o banco
try:
    conn = psycopg2.connect(dbname=dbname, user=user,
                            password=password, host=host)
    print("Conexão efetuada com sucesso")   
    
except OperationalError as e:
    print(f"Erro na conexção:{e}")

cursor = conn.cursor()

for time in dados:
    id = time["id"]
    abbreviation = time["abbreviation"]
    city = time["city"]
    conference = time["conference"]
    division = time["division"]
    full_name = time["full_name"]
    name = time["name"]

    sql = "INSERT INTO time(id, abbreviation, city, conference, division, full_name, name) VALUES (%s, %s, %s, %s, %s, %s, %s);"
    values = (id, abbreviation, city, conference, division, full_name, name)
    try:
        cursor.execute(sql,values)
        print("Inserindo dados no banco")
    except OperationalError as e:
        print("Erro ao inserir os dados")
        
cursor.close()
conn.commit()
    
try:
    conn.close
    print("Fechou")
except OperationalError as e:
    print(f"Fechou")