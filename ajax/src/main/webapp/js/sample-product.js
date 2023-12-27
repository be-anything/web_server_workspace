document.querySelector("#btn-product").addEventListener('click', (e) => {
    console.log(e.target);
    $.ajax( {
        url : `${contextPath}/xml/sample-product.xml`,
        method : "get",
        dataType : "xml",
        success(xmlDoc) {
            const tbody = document.querySelector("#products tbody");
            tbody.innerHTML = '';

            console.dir(xmlDoc);
            const products = xmlDoc.querySelectorAll("Product");
            products.forEach((product) => {
                const attrs = [...product.children];
                tbody.innerHTML += `<tr>${attrs.reduce((tds, attr) => {
                    return tds + `<td>${attr.textContent}</td>`;
                }, "")}</tr>`;
            });
        }
    })
});



























