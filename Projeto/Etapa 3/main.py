import requests
from pymongo import MongoClient

# URL da API externa que fornece dados em JSON
api_url = "https://hp-api.onrender.com/api/spells"

# Conexão com o banco de dados MongoDB 
client = MongoClient('localhost', 27017) #Estabeleço a conexão
db = client['harry_potter'] #Informo o banco de dados
collection = db['spells'] #Informo a collection

# Função para obter os dados da API Externa
def get_data_from_api():
    try:
        response = requests.get(api_url) #A biblioteca requests faz uma solição HTTP GET à url e atribui a variável response
        if response.status_code == 200: #Verifica o código da resposta obtida
            return response.json() #Converte a estrutura Json em uma estrutura de dados python
        else:
            print(f"Erro ao obter dados da API. Código de status: {response.status_code}")
            return None 
    except Exception as e:
        print(f"Erro ao fazer a solicitação à API: {str(e)}")
        return None
    

# Função para inserir os dados na coleção do MongoDB
def insert_data_into_mongodb(data):
    try:
        result = collection.insert_many(data) #Usa o método insert many do mongo para fazer a inserção de todos os dados obtidos da api
        print(f"{len(result.inserted_ids)} documentos inseridos no MongoDB")
    except Exception as e:
        print(f"Erro ao inserir dados no MongoDB: {str(e)}")
        
if __name__ == '__main__':
    data = get_data_from_api()
    if data:
        insert_data_into_mongodb(data)