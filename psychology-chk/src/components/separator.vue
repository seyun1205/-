<template>
    <el-breadcrumb separator="/">
        <el-breadcrumb-item >&nbsp;&nbsp;&nbsp;点击快速进入</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/test' }">心理测试</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/knowledge' }">心理知识</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/help' }">心理咨询</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/comment' }">留言板</el-breadcrumb-item>
    </el-breadcrumb>
</template>

<style>

</style>