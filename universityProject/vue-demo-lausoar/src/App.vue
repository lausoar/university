<template>
  <div id="app">
    <myHeader></myHeader>
    <router-view/>
  </div>
</template>

<script>
import myHeader from './components/myHeader';

export default {
  name: 'App',
  components: {
    myHeader
  },
  data() {

    return {
    
    };
  },
}
</script>

<style lang="scss">

@media (min-width: 768px) {
    .news-input{
        width: 50%;
    }
}

body::before{
    display: block;
    content: '';
    height: 56px;
}
.nav {
    display: flex;
    flex-wrap: wrap;
    padding-left: 265px;
    margin-bottom: 0;
    list-style: none;
}
.nav-item .nav-link a {
    text-decoration: none; 
}
</style>
