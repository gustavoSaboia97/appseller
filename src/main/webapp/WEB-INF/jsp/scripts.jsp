<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script>
    function deleteEntity(routeName, id){
        let url = 'http://localhost:8080/api/' + routeName + '/' + id
        fetch(url, {
            method: 'DELETE'
        }).then(() => window.location.reload()).catch(error => console.log(error))
    }
</script>