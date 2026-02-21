# Iterator

механизм перебора элементов некоторого объекта 
(объект должен реализовать этот механизм)

Iterator<T> - базовый интерфейс

boolean hasNext()
T next()

# Iterable - описание объекта как итерируемого (гарантия наличия итератора)

iterface Iterable<T> {
    Iterator<T> iterator();
    //...
}