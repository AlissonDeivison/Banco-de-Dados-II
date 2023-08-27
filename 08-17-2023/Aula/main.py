import xml.etree.cElementTree as ET

tree =  ET.parse('alunos.xml')
root =  tree.getroot()

for aluno in root.findall('aluno'):
    nome = aluno.find('nome').text
    print('Nome do aluno: ',nome)