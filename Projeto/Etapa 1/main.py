import requests
import csv

requisicao = requests.get("https://www.balldontlie.io/api/v1/teams")
dados = requisicao.json()['data']
csv_file = 'times.csv'

# Escrevendo os dados no arquivo CSV
with open(csv_file,'w',newline='', encoding='utf-8') as file:
    csv_writer = csv.writer(file, delimiter=',')

    # Escrevendo o cabeçalho do CSV
    csv_writer.writerow(['id', 'abbreviation', 'city', 'conference', 'division', 'full_name', 'name'])   
    
    # Escrevendo os dados de cada time
    for time in dados:
        csv_writer.writerow([time['id'],time['abbreviation'],time['city'],time['conference'],time['division'],time['full_name'],time['name']])

print(f'O arquivo {csv_file} foi criado com sucesso.')