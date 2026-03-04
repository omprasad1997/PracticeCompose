package com.example.practicecompose.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.practicecompose.data.model.UserDto
import com.example.practicecompose.data.remote.UserApi

class UserPagingSource(
    private val api: UserApi
) : PagingSource<Int, UserDto>() {
    override fun getRefreshKey(state: PagingState<Int, UserDto>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, UserDto> {

        val page = params.key ?: 1

        return try {

            val users = api.getUsers(page)

            LoadResult.Page(
                data = users,
                prevKey = null,
                nextKey = page + 1
            )

        } catch (e: Exception) {

            LoadResult.Error(e)

        }
    }
}