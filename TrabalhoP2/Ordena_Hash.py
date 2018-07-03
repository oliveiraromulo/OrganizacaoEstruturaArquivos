import struct
import hashlib
import sys

hashsize = 500000001
nomeArquivo = "bolsa.csv"
nomeNovo = "bolsa-hash.dat"
indexFormat = "8sLL"
colunaIndice = 8

indexStruct = struct.Struct(indexFormat)


def h(chave):
    global hashsize
    return int(hashlib.sha1(chave).hexdigest(), 16) % hashsize


fileI = open(nomeNovo, "wb")
emptyIndexRecord = indexStruct.pack(" ", 0, 0)
for i in range(0, hashsize):
    fileI.write(emptyIndexRecord)
fileI.close()

file = open(nomeArquivo, "rb")
fileI = open(nomeNovo, "r+b")

fileI.seek(0, os.SEEK_END)
fileIndexSize = fi.tell()
print("IndexFileSize", fileIndexSize)


recordNumber = 0
while True:
    linha = f.readlines()
    if linha == "":
        break

    record = linha
    p = h(record[colunaIndice])
    fileI.seek(p*indexStruct.size, os.SEEK_SET)
    emptyIndexRecord = indexStruct.unpack(fileI.read(indexStruct.size))
    fileI.seek(p*indexStruct.size, os.SEEK_SET)
    if indexRecord[0][0] == "\0":
        fileI.write(indexStruct.pack(record[colunaIndice], recordNumber, 0))
    else:
        prox = IndexRecord[2]
        fileI.write(indexStruct.pack(indexRecord[0], indexRecord[1], fileIndexSize))
        fileI.seek(0, os.SEEK_END)
        fileI.write(indexStruct.pack(record[colunaIndice], recordNumber, prox))
        fileIndexSize = fileI.tell()
    recordNumber += 1
file.close()
fileI.close()
