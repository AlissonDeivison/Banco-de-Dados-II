import requests

requisicao = requests.get("https://eonet.gsfc.nasa.gov/api/v2.1/categories")

dados = requisicao.json()

listaDeRequisicoes = dados['categories']

for category in listaDeRequisicoes:
    print(f'ID: {category["id"]}')
    print(f'Título: {category["title"]}')
    print(f'Link: {category["link"]}')
    print(f'Descrição: {category["description"]}')
    print(f'Layer: {category["layers"]}')
    print()