import xml.etree.cElementTree as ET

tree =  ET.parse('passageiros.xml')
root =  tree.getroot()

numeroPassageiros = 0
origens = []
destinos = []

for passageiro in root.findall('passageiro'):
    numeroPassageiros +=1
    origem = passageiro.find('origem').text
    destino = passageiro.find('destino').text
    if not origem in origens:
        origens.append(origem)
    if not destino in destinos:    
        destinos.append(destino)
    
print ("Numero de passageiro: ", numeroPassageiros)
print ("Origens: ", origens)
print ("Destinos: ", destinos)
